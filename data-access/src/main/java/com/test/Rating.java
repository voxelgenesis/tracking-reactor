package com.test;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String value;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private User user;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TrackingEntry trackingEntry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrackingEntry getTrackingEntry() {
		return trackingEntry;
	}

	public void setTrackingEntry(TrackingEntry trackingEntry) {
		this.trackingEntry = trackingEntry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : (user.getId() == null ? 0 : user.getId().hashCode()));
		result = prime * result + ((trackingEntry == null) ? 0 : (trackingEntry.getId() == null ? 0 : trackingEntry.getId().hashCode()));
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rating)) {
			return false;
		}
		Rating other = (Rating) obj;
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else {
			if (other.user == null) {
				return false;
			}

			if (!user.getId().equals(other.user.getId())) {
				return false;
			}
		}
		if (trackingEntry == null) {
			if (other.trackingEntry != null) {
				return false;
			}
		} else {
			if (other.trackingEntry == null) {
				return false;
			}

			if (!trackingEntry.getId().equals(other.trackingEntry.getId())) {
				return false;
			}
		}
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", value=" + value + ", user=" + user + ", trackingEntry=" + trackingEntry + "]";
	}

}
