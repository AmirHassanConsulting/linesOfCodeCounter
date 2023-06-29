package com.exxeta.loccounter.util;

import java.util.Properties;

/**
 * This class is responsible for sending marketing emails.
 */
public class Logic {

  private String from;
  private String to;
  private String subject;
  private String body;

  /**
   * Constructor for EmailSender
   *
   * @param from    The email address of the sender
   * @param to      The email address of the recipient
   * @param subject The subject of the email
   * @param body    The body of the email
   */
  public Logic(String from, String to, String subject, String body) {
    this.from = from;
    this.to = to;
    this.subject = subject;
    this.body = body;
  }

  /**
   * Sends the email.
   */
  public void send() {
    // Get system properties
    Properties props = System.getProperties();

    // Setup mail server
    props.put("mail.smtp.host", "smtp.example.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    // Get the default Session object.
  }
}