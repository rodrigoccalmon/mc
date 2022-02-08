package com.rodrigocalmon.cursomc.service;

import org.springframework.mail.SimpleMailMessage;

import com.rodrigocalmon.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}
