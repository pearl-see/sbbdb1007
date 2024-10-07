package com.mysite.project;

import java.util.List;

public class PageDTO {
	private int page;
	private int size;
	private int totalPages;
	private long totalElements;
	private List<Message> content;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public List<Message> getContent() {
		return content;
	}
	public void setContent(List<Message> content) {
		this.content = content;
	}
	public PageDTO(int page, int size, int totalPages, long totalElements, List<Message> content) {
		super();
		this.page = page;
		this.size = size;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.content = content;
	}
}