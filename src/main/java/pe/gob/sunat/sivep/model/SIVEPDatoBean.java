package pe.gob.sunat.sivep.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import pe.gob.sunat.sivep.web.util.EsType;

@EsType("sunattest4")
public final class SIVEPDatoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty private String NUM_CORRIV;
	@JsonProperty private String NUM_CORREDOC;
	@JsonProperty private String COD_ADUANA;
	@JsonProperty private String ANN_PRESEN;
	@JsonProperty private String NUM_DECLARACION;
	@JsonProperty private String COD_REGIMEN;
	@JsonProperty private String COD_CANAL;
	@JsonProperty private String COD_MODALIDAD;
	@JsonProperty private String FEC_DECLARACION;
	@JsonProperty private String COD_TIPDOCIMPORT;
	@JsonProperty private String NUM_DOCIMPORT;
	@JsonProperty private String NOM_IMPORT;
	@JsonProperty private String IND_CONCLU;
	@JsonProperty private String FEC_CONCLU;
	@JsonProperty private String IND_IMPFREC;
	@JsonProperty private String IND_GARANTIA;
	@JsonProperty private String IND_GARANTIACONC;
	@JsonProperty private String NUM_GARANTIA;
	@JsonProperty private String COD_TIPOLIQUIDA;
	@JsonProperty private String COD_ESTDR;
	@JsonProperty private String COD_ORIGEN;
	@JsonProperty private String NUM_SERIE;
	@JsonProperty private String FEC_EMBARQUE;
	@JsonProperty private String COD_PUER_EMBAR;
	@JsonProperty private String DES_PUER_EMBAR;
	@JsonProperty private String NUM_DOCTRANSP;
	@JsonProperty private String NUM_SECITEM;
	@JsonProperty private String NUM_PARARANCEL;
	@JsonProperty private String DES_AROANO;
	@JsonProperty private String MTO_FOBUNITARIO;
	@JsonProperty private String MTO_FOBITEM;
	@JsonProperty private String MTO_FOBKG;
	@JsonProperty private String MTO_AJUUNITARIO;
	@JsonProperty private String CNT_UNI;
	@JsonProperty private String COD_UNICOMER;
	@JsonProperty private String COD_TIPOESTMERC;
	@JsonProperty private String COD_ESTMERC;
	@JsonProperty private String COD_PAISORIGEN;
	@JsonProperty private String COD_PAISADQUI;
	@JsonProperty private String MTO_FOBPROVIS;
	@JsonProperty private String COD_TIPOVALFOB;
	@JsonProperty private String IND_SENSIBLE;
	@JsonProperty private String DES_COMER;
	@JsonProperty private String DES_MARCA;
	@JsonProperty private String DES_MODELO;
	@JsonProperty private String DES_CARATIPO;
	@JsonProperty private String DES_CLASEVARI;
	@JsonProperty private String DES_USOAPLIC;
	@JsonProperty private String DES_MATERIALCOMP;
	@JsonProperty private String DES_COM1;
	@JsonProperty private String DES_COM2;
	@JsonProperty private String DES_COM3;
	@JsonProperty private String OBS_OBS;
	@JsonProperty private String COD_TIPDESCRMIN;
	@JsonProperty private String IND_DESCRMIN;
	@JsonProperty private String DES_BUSQUEDA;
	@JsonProperty private String NUM_SECFACT;
	@JsonProperty private String NUM_FACT;
	@JsonProperty private String FEC_FACT;
	@JsonProperty private String COD_PAISEMBARQUE;
	@JsonProperty private String NUM_SECPROVE;
	@JsonProperty private String NOM_PROVE;
	@JsonProperty private String COD_PAISPROVE;
	@JsonProperty private String COD_NIVCOM;
	@JsonProperty private String COD_CONDPROVE;
	@JsonProperty private String COD_NATUTRANS;
	@JsonProperty private String IND_VINCULADO;
	@JsonProperty private String MTO_FOBDR;
	@JsonProperty private String MTO_FOBCP;
	@JsonProperty private String MTO_FOBDDR;
	@JsonProperty private String IND_BQ;
	@JsonProperty private String NUM_PARBQ;
	@JsonProperty private String DES_PRODUCBQ;
	@JsonProperty private String DES_INFORMBQ;
	@JsonProperty private String DES_COMPBQ;
	@JsonProperty private String DES_USOBQ;
	@JsonProperty private String COD_ADUANABQ;
	@JsonProperty private String ANN_BQ;
	@JsonProperty private String NUM_BQ;
	@JsonProperty private String IND_BQCOM;
	@JsonProperty private String NUM_SECVALORACT;
	@JsonProperty private String COD_ESTVAL;
	@JsonProperty private String FEC_GENVAL;
	@JsonProperty private String COD_CRITERIO;
	@JsonProperty private String COD_FUNCVAL;
	@JsonProperty private String NOM_FUNCVAL;
	@JsonProperty private String FEC_CARGASIS;
	@JsonProperty private String NUM_GRAMAJE;
	@JsonProperty private String NUM_ANCHO;
	@JsonProperty private String COD_COMPOSICION1;
	@JsonProperty private String DES_COMPOSICION1;
	@JsonProperty private String CNT_COMPOSICION1;
	@JsonProperty private String COD_COMPOSICION2;
	@JsonProperty private String DES_COMPOSICION2;
	@JsonProperty private String CNT_COMPOSICION2;
	@JsonProperty private String COD_COMPOSICION3;
	@JsonProperty private String DES_COMPOSICION3;
	@JsonProperty private String CNT_COMPOSICION3;
	@JsonProperty private String NUM_ESPESOR;
	@JsonProperty private String COD_ACABADO1;
	@JsonProperty private String DES_ACABADO1;
	@JsonProperty private String COD_ACABADO2;
	@JsonProperty private String DES_ACABADO2;
	@JsonProperty private String IND_DEL;
	@JsonProperty private String MTO_FOBDECINI;
	
	@JsonIgnore	private boolean export;
	
	@JsonIgnore
	//@JsonProperty("descmin")
	private List<SIVEPDescripcionMinimaBean> descmin= new ArrayList<SIVEPDescripcionMinimaBean>();

	public String getNUM_CORRIV() {
		return NUM_CORRIV;
	}

	public void setNUM_CORRIV(String nUM_CORRIV) {
		NUM_CORRIV = nUM_CORRIV;
	}

	public String getNUM_CORREDOC() {
		return NUM_CORREDOC;
	}

	public void setNUM_CORREDOC(String nUM_CORREDOC) {
		NUM_CORREDOC = nUM_CORREDOC;
	}

	public String getCOD_ADUANA() {
		return COD_ADUANA;
	}

	public void setCOD_ADUANA(String cOD_ADUANA) {
		COD_ADUANA = cOD_ADUANA;
	}

	public String getANN_PRESEN() {
		return ANN_PRESEN;
	}

	public void setANN_PRESEN(String aNN_PRESEN) {
		ANN_PRESEN = aNN_PRESEN;
	}

	public String getNUM_DECLARACION() {
		return NUM_DECLARACION;
	}

	public void setNUM_DECLARACION(String nUM_DECLARACION) {
		NUM_DECLARACION = nUM_DECLARACION;
	}

	public String getCOD_REGIMEN() {
		return COD_REGIMEN;
	}

	public void setCOD_REGIMEN(String cOD_REGIMEN) {
		COD_REGIMEN = cOD_REGIMEN;
	}

	public String getCOD_CANAL() {
		return COD_CANAL;
	}

	public void setCOD_CANAL(String cOD_CANAL) {
		COD_CANAL = cOD_CANAL;
	}

	public String getCOD_MODALIDAD() {
		return COD_MODALIDAD;
	}

	public void setCOD_MODALIDAD(String cOD_MODALIDAD) {
		COD_MODALIDAD = cOD_MODALIDAD;
	}

	public String getFEC_DECLARACION() {
		return FEC_DECLARACION;
	}

	public void setFEC_DECLARACION(String fEC_DECLARACION) {
		FEC_DECLARACION = fEC_DECLARACION;
	}

	public String getCOD_TIPDOCIMPORT() {
		return COD_TIPDOCIMPORT;
	}

	public void setCOD_TIPDOCIMPORT(String cOD_TIPDOCIMPORT) {
		COD_TIPDOCIMPORT = cOD_TIPDOCIMPORT;
	}

	public String getNUM_DOCIMPORT() {
		return NUM_DOCIMPORT;
	}

	public void setNUM_DOCIMPORT(String nUM_DOCIMPORT) {
		NUM_DOCIMPORT = nUM_DOCIMPORT;
	}

	public String getNOM_IMPORT() {
		return NOM_IMPORT;
	}

	public void setNOM_IMPORT(String nOM_IMPORT) {
		NOM_IMPORT = nOM_IMPORT;
	}

	public String getIND_CONCLU() {
		return IND_CONCLU;
	}

	public void setIND_CONCLU(String iND_CONCLU) {
		IND_CONCLU = iND_CONCLU;
	}

	public String getFEC_CONCLU() {
		return FEC_CONCLU;
	}

	public void setFEC_CONCLU(String fEC_CONCLU) {
		FEC_CONCLU = fEC_CONCLU;
	}

	public String getIND_IMPFREC() {
		return IND_IMPFREC;
	}

	public void setIND_IMPFREC(String iND_IMPFREC) {
		IND_IMPFREC = iND_IMPFREC;
	}

	public String getIND_GARANTIA() {
		return IND_GARANTIA;
	}

	public void setIND_GARANTIA(String iND_GARANTIA) {
		IND_GARANTIA = iND_GARANTIA;
	}

	public String getIND_GARANTIACONC() {
		return IND_GARANTIACONC;
	}

	public void setIND_GARANTIACONC(String iND_GARANTIACONC) {
		IND_GARANTIACONC = iND_GARANTIACONC;
	}

	public String getNUM_GARANTIA() {
		return NUM_GARANTIA;
	}

	public void setNUM_GARANTIA(String nUM_GARANTIA) {
		NUM_GARANTIA = nUM_GARANTIA;
	}

	public String getCOD_TIPOLIQUIDA() {
		return COD_TIPOLIQUIDA;
	}

	public void setCOD_TIPOLIQUIDA(String cOD_TIPOLIQUIDA) {
		COD_TIPOLIQUIDA = cOD_TIPOLIQUIDA;
	}

	public String getCOD_ESTDR() {
		return COD_ESTDR;
	}

	public void setCOD_ESTDR(String cOD_ESTDR) {
		COD_ESTDR = cOD_ESTDR;
	}

	public String getCOD_ORIGEN() {
		return COD_ORIGEN;
	}

	public void setCOD_ORIGEN(String cOD_ORIGEN) {
		COD_ORIGEN = cOD_ORIGEN;
	}

	public String getNUM_SERIE() {
		return NUM_SERIE;
	}

	public void setNUM_SERIE(String nUM_SERIE) {
		NUM_SERIE = nUM_SERIE;
	}

	public String getFEC_EMBARQUE() {
		return FEC_EMBARQUE;
	}

	public void setFEC_EMBARQUE(String fEC_EMBARQUE) {
		FEC_EMBARQUE = fEC_EMBARQUE;
	}

	public String getCOD_PUER_EMBAR() {
		return COD_PUER_EMBAR;
	}

	public void setCOD_PUER_EMBAR(String cOD_PUER_EMBAR) {
		COD_PUER_EMBAR = cOD_PUER_EMBAR;
	}

	public String getDES_PUER_EMBAR() {
		return DES_PUER_EMBAR;
	}

	public void setDES_PUER_EMBAR(String dES_PUER_EMBAR) {
		DES_PUER_EMBAR = dES_PUER_EMBAR;
	}

	public String getNUM_DOCTRANSP() {
		return NUM_DOCTRANSP;
	}

	public void setNUM_DOCTRANSP(String nUM_DOCTRANSP) {
		NUM_DOCTRANSP = nUM_DOCTRANSP;
	}

	public String getNUM_SECITEM() {
		return NUM_SECITEM;
	}

	public void setNUM_SECITEM(String nUM_SECITEM) {
		NUM_SECITEM = nUM_SECITEM;
	}

	public String getNUM_PARARANCEL() {
		return NUM_PARARANCEL;
	}

	public void setNUM_PARARANCEL(String nUM_PARARANCEL) {
		NUM_PARARANCEL = nUM_PARARANCEL;
	}

	public String getDES_AROANO() {
		return DES_AROANO;
	}

	public void setDES_AROANO(String dES_AROANO) {
		DES_AROANO = dES_AROANO;
	}

	public String getMTO_FOBUNITARIO() {
		return MTO_FOBUNITARIO;
	}

	public void setMTO_FOBUNITARIO(String mTO_FOBUNITARIO) {
		MTO_FOBUNITARIO = mTO_FOBUNITARIO;
	}

	public String getMTO_FOBITEM() {
		return MTO_FOBITEM;
	}

	public void setMTO_FOBITEM(String mTO_FOBITEM) {
		MTO_FOBITEM = mTO_FOBITEM;
	}

	public String getMTO_FOBKG() {
		return MTO_FOBKG;
	}

	public void setMTO_FOBKG(String mTO_FOBKG) {
		MTO_FOBKG = mTO_FOBKG;
	}

	public String getMTO_AJUUNITARIO() {
		return MTO_AJUUNITARIO;
	}

	public void setMTO_AJUUNITARIO(String mTO_AJUUNITARIO) {
		MTO_AJUUNITARIO = mTO_AJUUNITARIO;
	}

	public String getCNT_UNI() {
		return CNT_UNI;
	}

	public void setCNT_UNI(String cNT_UNI) {
		CNT_UNI = cNT_UNI;
	}

	public String getCOD_UNICOMER() {
		return COD_UNICOMER;
	}

	public void setCOD_UNICOMER(String cOD_UNICOMER) {
		COD_UNICOMER = cOD_UNICOMER;
	}

	public String getCOD_TIPOESTMERC() {
		return COD_TIPOESTMERC;
	}

	public void setCOD_TIPOESTMERC(String cOD_TIPOESTMERC) {
		COD_TIPOESTMERC = cOD_TIPOESTMERC;
	}

	public String getCOD_ESTMERC() {
		return COD_ESTMERC;
	}

	public void setCOD_ESTMERC(String cOD_ESTMERC) {
		COD_ESTMERC = cOD_ESTMERC;
	}

	public String getCOD_PAISORIGEN() {
		return COD_PAISORIGEN;
	}

	public void setCOD_PAISORIGEN(String cOD_PAISORIGEN) {
		COD_PAISORIGEN = cOD_PAISORIGEN;
	}

	public String getCOD_PAISADQUI() {
		return COD_PAISADQUI;
	}

	public void setCOD_PAISADQUI(String cOD_PAISADQUI) {
		COD_PAISADQUI = cOD_PAISADQUI;
	}

	public String getMTO_FOBPROVIS() {
		return MTO_FOBPROVIS;
	}

	public void setMTO_FOBPROVIS(String mTO_FOBPROVIS) {
		MTO_FOBPROVIS = mTO_FOBPROVIS;
	}

	public String getCOD_TIPOVALFOB() {
		return COD_TIPOVALFOB;
	}

	public void setCOD_TIPOVALFOB(String cOD_TIPOVALFOB) {
		COD_TIPOVALFOB = cOD_TIPOVALFOB;
	}

	public String getIND_SENSIBLE() {
		return IND_SENSIBLE;
	}

	public void setIND_SENSIBLE(String iND_SENSIBLE) {
		IND_SENSIBLE = iND_SENSIBLE;
	}

	public String getDES_COMER() {
		return DES_COMER;
	}

	public void setDES_COMER(String dES_COMER) {
		DES_COMER = dES_COMER;
	}

	public String getDES_MARCA() {
		return DES_MARCA;
	}

	public void setDES_MARCA(String dES_MARCA) {
		DES_MARCA = dES_MARCA;
	}

	public String getDES_MODELO() {
		return DES_MODELO;
	}

	public void setDES_MODELO(String dES_MODELO) {
		DES_MODELO = dES_MODELO;
	}

	public String getDES_CARATIPO() {
		return DES_CARATIPO;
	}

	public void setDES_CARATIPO(String dES_CARATIPO) {
		DES_CARATIPO = dES_CARATIPO;
	}

	public String getDES_CLASEVARI() {
		return DES_CLASEVARI;
	}

	public void setDES_CLASEVARI(String dES_CLASEVARI) {
		DES_CLASEVARI = dES_CLASEVARI;
	}

	public String getDES_USOAPLIC() {
		return DES_USOAPLIC;
	}

	public void setDES_USOAPLIC(String dES_USOAPLIC) {
		DES_USOAPLIC = dES_USOAPLIC;
	}

	public String getDES_MATERIALCOMP() {
		return DES_MATERIALCOMP;
	}

	public void setDES_MATERIALCOMP(String dES_MATERIALCOMP) {
		DES_MATERIALCOMP = dES_MATERIALCOMP;
	}

	public String getDES_COM1() {
		return DES_COM1;
	}

	public void setDES_COM1(String dES_COM1) {
		DES_COM1 = dES_COM1;
	}

	public String getDES_COM2() {
		return DES_COM2;
	}

	public void setDES_COM2(String dES_COM2) {
		DES_COM2 = dES_COM2;
	}

	public String getDES_COM3() {
		return DES_COM3;
	}

	public void setDES_COM3(String dES_COM3) {
		DES_COM3 = dES_COM3;
	}

	public String getOBS_OBS() {
		return OBS_OBS;
	}

	public void setOBS_OBS(String oBS_OBS) {
		OBS_OBS = oBS_OBS;
	}

	public String getCOD_TIPDESCRMIN() {
		return COD_TIPDESCRMIN;
	}

	public void setCOD_TIPDESCRMIN(String cOD_TIPDESCRMIN) {
		COD_TIPDESCRMIN = cOD_TIPDESCRMIN;
	}

	public String getIND_DESCRMIN() {
		return IND_DESCRMIN;
	}

	public void setIND_DESCRMIN(String iND_DESCRMIN) {
		IND_DESCRMIN = iND_DESCRMIN;
	}

	public String getDES_BUSQUEDA() {
		return DES_BUSQUEDA;
	}

	public void setDES_BUSQUEDA(String dES_BUSQUEDA) {
		DES_BUSQUEDA = dES_BUSQUEDA;
	}

	public String getNUM_SECFACT() {
		return NUM_SECFACT;
	}

	public void setNUM_SECFACT(String nUM_SECFACT) {
		NUM_SECFACT = nUM_SECFACT;
	}

	public String getNUM_FACT() {
		return NUM_FACT;
	}

	public void setNUM_FACT(String nUM_FACT) {
		NUM_FACT = nUM_FACT;
	}

	public String getFEC_FACT() {
		return FEC_FACT;
	}

	public void setFEC_FACT(String fEC_FACT) {
		FEC_FACT = fEC_FACT;
	}

	public String getCOD_PAISEMBARQUE() {
		return COD_PAISEMBARQUE;
	}

	public void setCOD_PAISEMBARQUE(String cOD_PAISEMBARQUE) {
		COD_PAISEMBARQUE = cOD_PAISEMBARQUE;
	}

	public String getNUM_SECPROVE() {
		return NUM_SECPROVE;
	}

	public void setNUM_SECPROVE(String nUM_SECPROVE) {
		NUM_SECPROVE = nUM_SECPROVE;
	}

	public String getNOM_PROVE() {
		return NOM_PROVE;
	}

	public void setNOM_PROVE(String nOM_PROVE) {
		NOM_PROVE = nOM_PROVE;
	}

	public String getCOD_PAISPROVE() {
		return COD_PAISPROVE;
	}

	public void setCOD_PAISPROVE(String cOD_PAISPROVE) {
		COD_PAISPROVE = cOD_PAISPROVE;
	}

	public String getCOD_NIVCOM() {
		return COD_NIVCOM;
	}

	public void setCOD_NIVCOM(String cOD_NIVCOM) {
		COD_NIVCOM = cOD_NIVCOM;
	}

	public String getCOD_CONDPROVE() {
		return COD_CONDPROVE;
	}

	public void setCOD_CONDPROVE(String cOD_CONDPROVE) {
		COD_CONDPROVE = cOD_CONDPROVE;
	}

	public String getCOD_NATUTRANS() {
		return COD_NATUTRANS;
	}

	public void setCOD_NATUTRANS(String cOD_NATUTRANS) {
		COD_NATUTRANS = cOD_NATUTRANS;
	}

	public String getIND_VINCULADO() {
		return IND_VINCULADO;
	}

	public void setIND_VINCULADO(String iND_VINCULADO) {
		IND_VINCULADO = iND_VINCULADO;
	}

	public String getMTO_FOBDR() {
		return MTO_FOBDR;
	}

	public void setMTO_FOBDR(String mTO_FOBDR) {
		MTO_FOBDR = mTO_FOBDR;
	}

	public String getMTO_FOBCP() {
		return MTO_FOBCP;
	}

	public void setMTO_FOBCP(String mTO_FOBCP) {
		MTO_FOBCP = mTO_FOBCP;
	}

	public String getMTO_FOBDDR() {
		return MTO_FOBDDR;
	}

	public void setMTO_FOBDDR(String mTO_FOBDDR) {
		MTO_FOBDDR = mTO_FOBDDR;
	}

	public String getIND_BQ() {
		return IND_BQ;
	}

	public void setIND_BQ(String iND_BQ) {
		IND_BQ = iND_BQ;
	}

	public String getNUM_PARBQ() {
		return NUM_PARBQ;
	}

	public void setNUM_PARBQ(String nUM_PARBQ) {
		NUM_PARBQ = nUM_PARBQ;
	}

	public String getDES_PRODUCBQ() {
		return DES_PRODUCBQ;
	}

	public void setDES_PRODUCBQ(String dES_PRODUCBQ) {
		DES_PRODUCBQ = dES_PRODUCBQ;
	}

	public String getDES_INFORMBQ() {
		return DES_INFORMBQ;
	}

	public void setDES_INFORMBQ(String dES_INFORMBQ) {
		DES_INFORMBQ = dES_INFORMBQ;
	}

	public String getDES_COMPBQ() {
		return DES_COMPBQ;
	}

	public void setDES_COMPBQ(String dES_COMPBQ) {
		DES_COMPBQ = dES_COMPBQ;
	}

	public String getDES_USOBQ() {
		return DES_USOBQ;
	}

	public void setDES_USOBQ(String dES_USOBQ) {
		DES_USOBQ = dES_USOBQ;
	}

	public String getCOD_ADUANABQ() {
		return COD_ADUANABQ;
	}

	public void setCOD_ADUANABQ(String cOD_ADUANABQ) {
		COD_ADUANABQ = cOD_ADUANABQ;
	}

	public String getANN_BQ() {
		return ANN_BQ;
	}

	public void setANN_BQ(String aNN_BQ) {
		ANN_BQ = aNN_BQ;
	}

	public String getNUM_BQ() {
		return NUM_BQ;
	}

	public void setNUM_BQ(String nUM_BQ) {
		NUM_BQ = nUM_BQ;
	}

	public String getIND_BQCOM() {
		return IND_BQCOM;
	}

	public void setIND_BQCOM(String iND_BQCOM) {
		IND_BQCOM = iND_BQCOM;
	}

	public String getNUM_SECVALORACT() {
		return NUM_SECVALORACT;
	}

	public void setNUM_SECVALORACT(String nUM_SECVALORACT) {
		NUM_SECVALORACT = nUM_SECVALORACT;
	}

	public String getCOD_ESTVAL() {
		return COD_ESTVAL;
	}

	public void setCOD_ESTVAL(String cOD_ESTVAL) {
		COD_ESTVAL = cOD_ESTVAL;
	}

	public String getFEC_GENVAL() {
		return FEC_GENVAL;
	}

	public void setFEC_GENVAL(String fEC_GENVAL) {
		FEC_GENVAL = fEC_GENVAL;
	}

	public String getCOD_CRITERIO() {
		return COD_CRITERIO;
	}

	public void setCOD_CRITERIO(String cOD_CRITERIO) {
		COD_CRITERIO = cOD_CRITERIO;
	}

	public String getCOD_FUNCVAL() {
		return COD_FUNCVAL;
	}

	public void setCOD_FUNCVAL(String cOD_FUNCVAL) {
		COD_FUNCVAL = cOD_FUNCVAL;
	}

	public String getNOM_FUNCVAL() {
		return NOM_FUNCVAL;
	}

	public void setNOM_FUNCVAL(String nOM_FUNCVAL) {
		NOM_FUNCVAL = nOM_FUNCVAL;
	}

	public String getFEC_CARGASIS() {
		return FEC_CARGASIS;
	}

	public void setFEC_CARGASIS(String fEC_CARGASIS) {
		FEC_CARGASIS = fEC_CARGASIS;
	}

	public String getNUM_GRAMAJE() {
		return NUM_GRAMAJE;
	}

	public void setNUM_GRAMAJE(String nUM_GRAMAJE) {
		NUM_GRAMAJE = nUM_GRAMAJE;
	}

	public String getNUM_ANCHO() {
		return NUM_ANCHO;
	}

	public void setNUM_ANCHO(String nUM_ANCHO) {
		NUM_ANCHO = nUM_ANCHO;
	}

	public String getCOD_COMPOSICION1() {
		return COD_COMPOSICION1;
	}

	public void setCOD_COMPOSICION1(String cOD_COMPOSICION1) {
		COD_COMPOSICION1 = cOD_COMPOSICION1;
	}

	public String getDES_COMPOSICION1() {
		return DES_COMPOSICION1;
	}

	public void setDES_COMPOSICION1(String dES_COMPOSICION1) {
		DES_COMPOSICION1 = dES_COMPOSICION1;
	}

	public String getCNT_COMPOSICION1() {
		return CNT_COMPOSICION1;
	}

	public void setCNT_COMPOSICION1(String cNT_COMPOSICION1) {
		CNT_COMPOSICION1 = cNT_COMPOSICION1;
	}

	public String getCOD_COMPOSICION2() {
		return COD_COMPOSICION2;
	}

	public void setCOD_COMPOSICION2(String cOD_COMPOSICION2) {
		COD_COMPOSICION2 = cOD_COMPOSICION2;
	}

	public String getDES_COMPOSICION2() {
		return DES_COMPOSICION2;
	}

	public void setDES_COMPOSICION2(String dES_COMPOSICION2) {
		DES_COMPOSICION2 = dES_COMPOSICION2;
	}

	public String getCNT_COMPOSICION2() {
		return CNT_COMPOSICION2;
	}

	public void setCNT_COMPOSICION2(String cNT_COMPOSICION2) {
		CNT_COMPOSICION2 = cNT_COMPOSICION2;
	}

	public String getCOD_COMPOSICION3() {
		return COD_COMPOSICION3;
	}

	public void setCOD_COMPOSICION3(String cOD_COMPOSICION3) {
		COD_COMPOSICION3 = cOD_COMPOSICION3;
	}

	public String getDES_COMPOSICION3() {
		return DES_COMPOSICION3;
	}

	public void setDES_COMPOSICION3(String dES_COMPOSICION3) {
		DES_COMPOSICION3 = dES_COMPOSICION3;
	}

	public String getCNT_COMPOSICION3() {
		return CNT_COMPOSICION3;
	}

	public void setCNT_COMPOSICION3(String cNT_COMPOSICION3) {
		CNT_COMPOSICION3 = cNT_COMPOSICION3;
	}

	public String getNUM_ESPESOR() {
		return NUM_ESPESOR;
	}

	public void setNUM_ESPESOR(String nUM_ESPESOR) {
		NUM_ESPESOR = nUM_ESPESOR;
	}

	public String getCOD_ACABADO1() {
		return COD_ACABADO1;
	}

	public void setCOD_ACABADO1(String cOD_ACABADO1) {
		COD_ACABADO1 = cOD_ACABADO1;
	}

	public String getDES_ACABADO1() {
		return DES_ACABADO1;
	}

	public void setDES_ACABADO1(String dES_ACABADO1) {
		DES_ACABADO1 = dES_ACABADO1;
	}

	public String getCOD_ACABADO2() {
		return COD_ACABADO2;
	}

	public void setCOD_ACABADO2(String cOD_ACABADO2) {
		COD_ACABADO2 = cOD_ACABADO2;
	}

	public String getDES_ACABADO2() {
		return DES_ACABADO2;
	}

	public void setDES_ACABADO2(String dES_ACABADO2) {
		DES_ACABADO2 = dES_ACABADO2;
	}

	public String getIND_DEL() {
		return IND_DEL;
	}

	public void setIND_DEL(String iND_DEL) {
		IND_DEL = iND_DEL;
	}

	public List<SIVEPDescripcionMinimaBean> getDescmin() {
		return descmin;
	}

	public void setDescmin(List<SIVEPDescripcionMinimaBean> descmin) {
		this.descmin = descmin;
	}

	/**
	 * @return the mTO_FOBDECINI
	 */
	public String getMTO_FOBDECINI() {
		return MTO_FOBDECINI;
	}

	/**
	 * @param mTO_FOBDECINI the mTO_FOBDECINI to set
	 */
	public void setMTO_FOBDECINI(String mTO_FOBDECINI) {
		MTO_FOBDECINI = mTO_FOBDECINI;
	}

	public boolean isExport() {
		return export;
	}

	public void setExport(boolean export) {
		this.export = export;
	}

	
	
}
