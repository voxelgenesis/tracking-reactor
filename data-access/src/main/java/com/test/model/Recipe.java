package com.test.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER )
	private TrackingEntry trackingEntry;

	private String author;

	private String book;

	@JsonManagedReference // Necessary to prevent infinite recursion when marshalling out a response.
	@OneToMany(mappedBy = "recipe", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER )
	private Set<Ingredient> ingredients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrackingEntry getTrackingEntry() {
		return trackingEntry;
	}

	public void setTrackingEntry(TrackingEntry trackingEntry) {
		this.trackingEntry = trackingEntry;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((trackingEntry == null) ? 0 : (trackingEntry.getId() == null ? 0 : trackingEntry.getId().hashCode()));
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
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (book == null) {
			if (other.book != null) {
				return false;
			}
		} else if (!book.equals(other.book)) {
			return false;
		}
		if (ingredients == null) {
			if (other.ingredients != null) {
				return false;
			}
		} else if (!ingredients.equals(other.ingredients)) {
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", trackingEntry=" + trackingEntry + ", author=" + author + ", book=" + book
				+ ", ingredients=" + ingredients + "]";
	}

}
