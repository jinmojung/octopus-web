package org.octopus.dto

class TreeDto {
	String id
	String text
	String state ="closed"
	boolean checked = false
	List<TreeDto> children = []
}
