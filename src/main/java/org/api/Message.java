package org.api;

public class Message {
  private long id;
  private String content;

  public static final Message EMPTY = new Message(-1L,"");

  public Message (long id, String content) {
    this.id  = id;
    this.content = content;
  }

  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  public long getId() {
    return this.id;
  }
  public void setId(long id) {
    this.id = id;
  }
}
