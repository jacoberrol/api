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

	public String toString() {
		return this.content;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		return (int)this.id;
	}
}
