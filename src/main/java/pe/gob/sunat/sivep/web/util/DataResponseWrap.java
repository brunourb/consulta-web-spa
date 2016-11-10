package pe.gob.sunat.sivep.web.util;

import java.util.List;

public class DataResponseWrap {

	private String sEcho;
	private long iTotalRecords = 0L;
	private long iTotalDisplayRecords = 0L;
	private List<? extends Object> aaData;
	
	private String iColumns;
	private String sColumns;
	private String iDisplayStart;
	private String iDisplayLength;
	

	public DataResponseWrap() {
		
	}
	
	public DataResponseWrap(List<? extends Object> lista, Long size) {
		
		
		this.sEcho = WebUtil.getRequest().getParameter("sEcho");
		this.iTotalRecords = size;
		this.iTotalDisplayRecords = size;
		this.iDisplayLength = WebUtil.getRequest().getParameter("iDisplayLength");
		this.aaData = lista;
		
	}
	
	public DataResponseWrap(List<? extends Object> list) {
		this(WebUtil.getRequest().getParameter("sEcho"), list.size(), list.size(), list);
	}

	public DataResponseWrap(String sEcho, long iTotalRecords, long iTotalDisplayRecords, List<? extends Object> aaData) {
		if (sEcho != null)
			this.sEcho = sEcho;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
		
		this.iColumns = WebUtil.getRequest().getParameter("iColumns");
		this.sColumns = WebUtil.getRequest().getParameter("sColumns");
		this.iDisplayStart = WebUtil.getRequest().getParameter("iDisplayStart");
	}

	public String getsEcho() {
		return this.sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public long getiTotalRecords() {
		return this.iTotalRecords;
	}

	public void setiTotalRecords(long iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public long getiTotalDisplayRecords() {
		return this.iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<? extends Object> getAaData() {
		return this.aaData;
	}

	public void setAaData(List<? extends Object> aaData) {
		this.aaData = aaData;
	}
	/**
	 * @return the iColumns
	 */
	public String getiColumns() {
		return iColumns;
	}
	/**
	 * @param iColumns the iColumns to set
	 */
	public void setiColumns(String iColumns) {
		this.iColumns = iColumns;
	}
	/**
	 * @return the sColumns
	 */
	public String getsColumns() {
		return sColumns;
	}
	/**
	 * @param sColumns the sColumns to set
	 */
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
	/**
	 * @return the iDisplayStart
	 */
	public String getiDisplayStart() {
		return iDisplayStart;
	}
	/**
	 * @param iDisplayStart the iDisplayStart to set
	 */
	public void setiDisplayStart(String iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	/**
	 * @return the iDisplayLength
	 */
	public String getiDisplayLength() {
		return iDisplayLength;
	}
	/**
	 * @param iDisplayLength the iDisplayLength to set
	 */
	public void setiDisplayLength(String iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	

}
