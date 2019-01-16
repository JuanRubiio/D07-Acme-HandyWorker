
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.MessageRepository;
import security.Authority;
import domain.Actor;
import domain.Message;
import domain.MessageBox;

@Service
@Transactional
public class MessageService {

	@Autowired
	private MessageRepository	messageRepository;
	@Autowired
	private ActorService		actorService;
	@Autowired
	private MessageBoxService	messageBoxService;
	@Autowired
	private UtilitiesService	utilitiesService;


	public Message create() {
		Message result;
		Actor sender;

		sender = this.actorService.getPrincipal();
		result = new Message();
		result.setSender(sender);
		result.setDate(new Date(System.currentTimeMillis()));
		result.setSpam(false);

		return result;
	}

	public Collection<Message> findAll() {
		Collection<Message> result;

		result = this.messageRepository.findAll();

		Assert.notNull(result);

		return result;
	}

	public Message findOne(final Integer messageId) {
		Message result;

		Assert.notNull(messageId);

		result = this.messageRepository.findOne(messageId);

		Assert.notNull(result);
		return result;
	}

	public Message save(final Message message) {
		Message result;

		Assert.notNull(message);
		Assert.notNull(message.getRecipient());
		if (this.utilitiesService.checkSpam(message.getBody()) || this.utilitiesService.checkSpam(message.getSubject()) || this.utilitiesService.checkSpam(message.getTags())) {
			message.setSpam(true);
			final Actor actor = this.actorService.getPrincipal();
			actor.setSuspicious(true);
			this.actorService.save(actor);
		}

		result = this.messageRepository.save(message);
		this.sendMessage(result);

		return result;
	}

	public void sendMessage(final Message message) {

		Actor sender;
		Actor recived;

		sender = message.getSender();
		recived = message.getRecipient();

		MessageBox inbox;
		inbox = this.messageBoxService.findSystemMessageBoxByActor("in box", recived.getId());
		MessageBox spamBox;
		spamBox = this.messageBoxService.findSystemMessageBoxByActor("spam box", recived.getId());
		MessageBox outbox;
		outbox = this.messageBoxService.findSystemMessageBoxByActor("out box", sender.getId());

		Assert.isTrue(inbox != null && outbox != null);
		if (spamBox != null && message.getSpam() == true) {
			spamBox.getMessages().add(message);
			this.messageBoxService.save(spamBox);
		} else {
			inbox.getMessages().add(message);
			this.messageBoxService.save(inbox);
		}
		outbox.getMessages().add(message);

		this.messageBoxService.save(outbox);

	}

	public void delete(final Message message) {
		Assert.notNull(message);

		this.messageRepository.delete(message);
	}

	public void moveMessage(final Message message, final Integer messageBoxId) {
		final Actor actor = this.actorService.getPrincipal();
		final MessageBox messageBox = this.messageBoxService.findOne(messageBoxId);
		Assert.notNull(messageBox);
		Assert.isTrue(messageBox.getActor().getId() == actor.getId());

		final Collection<MessageBox> boxesfordelete = this.messageBoxService.getMessageBoxsByActor(this.actorService.getPrincipal().getId());
		for (final MessageBox b : boxesfordelete)
			if (b.getMessages().contains(message)) {
				b.getMessages().remove(message);
				this.messageBoxService.save(b);
			}
		this.messageBoxService.saveMessageInBox(message, messageBox);
	}

	public void delete(final Integer messageId) {
		Assert.isTrue(messageId != 0 && messageId != null);
		Message message;
		message = this.messageRepository.findOne(messageId);
		Assert.isTrue(message != null);

		Assert.isTrue(this.checkPrincipalActor(message));
		final MessageBox mes = this.messageBoxService.findSystemMessageBox("trash box");
		Assert.notNull(mes);
		final Collection<MessageBox> boxes = this.messageBoxService.getMessageBoxesByMessageId(message.getId());
		final Collection<MessageBox> boxesfordelete = this.messageBoxService.getMessageBoxsByActor(this.actorService.getPrincipal().getId());

		if (!mes.getMessages().contains(message)) {
			this.messageBoxService.saveMessageInBox(message, mes);
			for (final MessageBox b : boxesfordelete)
				if (b != mes) {
					b.getMessages().remove(message);
					this.messageBoxService.save(b);
				}
		} else if (boxes.isEmpty())
			this.delete(message);
		else
			for (final MessageBox b : boxesfordelete) {
				b.getMessages().remove(message);
				this.messageBoxService.save(b);
			}

	}
	public void broadcast(final Message message) {
		Assert.notNull(message);

		final Actor administrador = this.actorService.getPrincipal();

		final Collection<Authority> autorities = administrador.getUserAccount().getAuthorities();
		final ArrayList<String> listAuth = new ArrayList<String>();

		if (!autorities.isEmpty())
			for (final Authority au : autorities)
				listAuth.add(au.getAuthority());

		Assert.isTrue(listAuth.contains("ADMIN"));

		final String subject = message.getSubject();
		final String body = message.getBody();
		final String priority = message.getPriority();
		final Boolean spam = message.getSpam();

		final Collection<Actor> actors = this.actorService.findAll();
		actors.remove(administrador);
		final Message m = this.create();
		m.setSender(administrador);
		m.setSubject(subject);
		m.setBody(body);
		m.setPriority(priority);
		m.setSpam(spam);
		for (final Actor a : actors) {

			m.setRecipient(a);
			this.save(m);

		}
	}

	public Boolean checkPrincipalActor(final Message message) {
		Boolean res = false;
		Assert.notNull(message);

		Actor actor;

		actor = this.actorService.getPrincipal();

		final Collection<MessageBox> messageboxes = this.messageBoxService.getMessageBoxsByActor(actor.getId());
		for (final MessageBox mes : messageboxes)
			if (mes.getMessages().contains(message))
				res = true;
		return res;
	}

	public Collection<Message> findMessagesByActorId(final int id) {
		return this.messageRepository.findMessagesByActorId(id);
	}

}
