package com.mfernando.meupiteu.services;

import org.springframework.mail.SimpleMailMessage;

import com.mfernando.meupiteu.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}
