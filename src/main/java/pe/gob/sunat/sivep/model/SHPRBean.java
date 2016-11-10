package pe.gob.sunat.sivep.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import pe.gob.sunat.sivep.web.util.EsType;

@EsType("shakespeare")
public class SHPRBean implements Serializable {


	//@JsonProperty @JsonIgnore private Integer line_id;
	@JsonProperty   private Integer line_id;
	@JsonProperty   private String play_name;
	@JsonProperty	private Integer speech_number;
	@JsonProperty	private String line_number;
	@JsonProperty	private String speaker;
	@JsonProperty	private String text_entry;
	
	@JsonIgnore	private boolean export;

	public Integer getLine_id() {
		return line_id;
	}

	public void setLine_id(Integer line_id) {
		this.line_id = line_id;
	}

	public String getPlay_name() {
		return play_name;
	}
	public void setPlay_name(String play_name) {
		this.play_name = play_name;
	}
	public Integer getSpeech_number() {
		return speech_number;
	}
	public void setSpeech_number(Integer speech_number) {
		this.speech_number = speech_number;
	}
	public String getLine_number() {
		return line_number;
	}
	public void setLine_number(String line_number) {
		this.line_number = line_number;
	}
	public String getSpeaker() {
		return speaker;
	}
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}
	public String getText_entry() {
		return text_entry;
	}
	public void setText_entry(String text_entry) {
		this.text_entry = text_entry;
	}
	public boolean isExport() {
		return export;
	}
	public void setExport(boolean export) {
		this.export = export;
	}
	
	
}
	