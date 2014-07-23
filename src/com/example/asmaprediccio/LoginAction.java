package com.example.asmaprediccio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	// AUTOMATICAMENTE GENERADO
	private static final long serialVersionUID = 1L;
	
	//CONTADOR
	private static int COUNT = 0;

	// LISTA CAMPOS
	private List<String> listaCampos;

	// CHECKBOXES
	private boolean crisisAsma;
	private boolean simptomesIntercrisisAsma;
	private boolean totesUrgenciesPrediccio;

	// TODOS LOS ATRIBUTOS TOMADOS EN CUENTA EN LA CLASIFICACION
	private String fechaini;
	private String edad;
	private String codigopoblacion;
	private String Altresmanifestacionsdatòpia;
	private String Edatdinicipatologiarespiratoriaanys;
	private String Símptomesintercrisisasma;
	private String CANControlAsmaNens07puntsboncontrol;
	private String Freqüènciacrisisasma;
	private String Ingresosperasma;
	private String Tractamentdebaseperlasma;
	private String acaros;
	private String budesonida;
	private String fluticasona;
	private String ciclesonida;
	private String mometasona;
	private String montelukast;
	private String singulair;
	private String salmeterolfluticasona;
	private String formoterolbudesonida;
	private String omalizumab;
	private String FEV1;
	private String FEF2575;
	private String Fumadorsaldomicilihabitual;
	private String Medicacióderescat;
	private String Antecedentsfamiliarsdatòpia;
	private String Dispneanocturna;
	private String Immunoteràpia;
	private String Crisisdasma;
	private String Símptomésambesforç;
	private String totesUrgencies;
	
	//PROBABILIDADES OUTCOMES
	private double porcentajeTotesUrgencies;
	private double porcentajeCrisisAsma;
	private double porcentajeSimtomesIntercrisisAsma;

	
	
	//EJECUCIÓN
	public String execute() {

		// SI queremos hacer predicción (uno de los checkbox está elegido)
		if (COUNT!=0) {

			// procesamos ficheros arff para predicciones
			ArffWriter.writeCrisisDAsma(processArffLineCrisisDAsma());
			ArffWriter.writeSimptomesIntercrisisAsma(processArffLineSimptomesIntercrisisAsma());
			ArffWriter.writeTotesUrgencies(processArffLineTotesUrgencies());

			List<double[]> predictions = WekaPredictor.classify();

			porcentajeTotesUrgencies = predictions.get(0)[1]*100;
			porcentajeSimtomesIntercrisisAsma = predictions.get(1)[1]*100;
			porcentajeCrisisAsma = predictions.get(2)[1]*100;
			
			COUNT = 0;
			return "success";
		}

		else {
			COUNT++;
			return "error";
		}

	}

	private String processArffLineCrisisDAsma() {
		String ret = "";

		ret += getFechaini() + ",";
		ret += getEdad() + ",";
		ret += getCodigopoblacion() + ",";
		ret += getAltresmanifestacionsdatòpia() + ",";
		ret += getEdatdinicipatologiarespiratoriaanys() + ",";
		//ret += getSímptomesintercrisisasma() + ",";
		ret += getCANControlAsmaNens07puntsboncontrol() + ",";
		ret += getFreqüènciacrisisasma() + ",";
		ret += getIngresosperasma() + ",";
		ret += getTractamentdebaseperlasma() + ",";
		ret += getAcaros() + ",";
		ret += getBudesonida() + ",";
		ret += getFluticasona() + ",";
		ret += getCiclesonida() + ",";
		ret += getMometasona() + ",";
		ret += getMontelukast() + ",";
		ret += getSingulair() + ",";
		ret += getSalmeterolfluticasona() + ",";
		ret += getFormoterolbudesonida() + ",";
		ret += getOmalizumab() + ",";
		ret += getFEV1() + ",";
		ret += getFEF2575() + ",";
		ret += getFumadorsaldomicilihabitual() + ",";
		ret += getMedicacióderescat() + ",";
		ret += getAntecedentsfamiliarsdatòpia() + ",";
		ret += getDispneanocturna() + ",";
		ret += getImmunoteràpia() + ",";
		ret += getCrisisdasma() + ",";
		ret += getSímptomésambesforç() + ",";
		//ret += getTotesUrgencies();

		ret = ret.replaceAll("null","?");
		
		return ret;
	}
	
	
	private String processArffLineTotesUrgencies() {
		String ret = "";

		ret += getFechaini() + ",";
		ret += getEdad() + ",";
		ret += getCodigopoblacion() + ",";
		ret += getAltresmanifestacionsdatòpia() + ",";
		ret += getEdatdinicipatologiarespiratoriaanys() + ",";
		//ret += getSímptomesintercrisisasma() + ",";
		ret += getCANControlAsmaNens07puntsboncontrol() + ",";
		ret += getFreqüènciacrisisasma() + ",";
		ret += getIngresosperasma() + ",";
		ret += getTractamentdebaseperlasma() + ",";
		ret += getAcaros() + ",";
		ret += getBudesonida() + ",";
		ret += getFluticasona() + ",";
		ret += getCiclesonida() + ",";
		ret += getMometasona() + ",";
		ret += getMontelukast() + ",";
		ret += getSingulair() + ",";
		ret += getSalmeterolfluticasona() + ",";
		ret += getFormoterolbudesonida() + ",";
		ret += getOmalizumab() + ",";
		ret += getFEV1() + ",";
		ret += getFEF2575() + ",";
		ret += getFumadorsaldomicilihabitual() + ",";
		ret += getMedicacióderescat() + ",";
		ret += getAntecedentsfamiliarsdatòpia() + ",";
		ret += getDispneanocturna() + ",";
		ret += getImmunoteràpia() + ",";
		//ret += getCrisisdasma() + ",";
		ret += getSímptomésambesforç() + ",";
		ret += getTotesUrgencies();

		ret = ret.replaceAll("null","?");
		
		return ret;
	}
	
	
	private String processArffLineSimptomesIntercrisisAsma() {
		String ret = "";

		ret += getFechaini() + ",";
		ret += getEdad() + ",";
		ret += getCodigopoblacion() + ",";
		ret += getAltresmanifestacionsdatòpia() + ",";
		ret += getEdatdinicipatologiarespiratoriaanys() + ",";
		ret += getSímptomesintercrisisasma() + ",";
		ret += getCANControlAsmaNens07puntsboncontrol() + ",";
		ret += getFreqüènciacrisisasma() + ",";
		ret += getIngresosperasma() + ",";
		ret += getTractamentdebaseperlasma() + ",";
		ret += getAcaros() + ",";
		ret += getBudesonida() + ",";
		ret += getFluticasona() + ",";
		ret += getCiclesonida() + ",";
		ret += getMometasona() + ",";
		ret += getMontelukast() + ",";
		ret += getSingulair() + ",";
		ret += getSalmeterolfluticasona() + ",";
		ret += getFormoterolbudesonida() + ",";
		ret += getOmalizumab() + ",";
		ret += getFEV1() + ",";
		ret += getFEF2575() + ",";
		ret += getFumadorsaldomicilihabitual() + ",";
		ret += getMedicacióderescat() + ",";
		ret += getAntecedentsfamiliarsdatòpia() + ",";
		ret += getDispneanocturna() + ",";
		ret += getImmunoteràpia() + ",";
		//ret += getCrisisdasma() + ",";
		ret += getSímptomésambesforç() + ",";
		//ret += getTotesUrgencies();

		ret = ret.replaceAll("null","?");
		
		return ret;
	}
	

	public List<String> getListaCampos() {
		try {
			listaCampos = Files
					.readAllLines(
							Paths.get("/home/alexis/git/WebSJDD/input/listaCamposPrediccion.txt"),
							Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaCampos;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getCodigopoblacion() {
		return codigopoblacion;
	}

	public void setCodigopoblacion(String codigopoblacion) {
		this.codigopoblacion = codigopoblacion;
	}

	public String getAltresmanifestacionsdatòpia() {
		return Altresmanifestacionsdatòpia;
	}

	public void setAltresmanifestacionsdatòpia(
			String altresmanifestacionsdatòpia) {
		Altresmanifestacionsdatòpia = altresmanifestacionsdatòpia;
	}

	public String getEdatdinicipatologiarespiratoriaanys() {
		return Edatdinicipatologiarespiratoriaanys;
	}

	public void setEdatdinicipatologiarespiratoriaanys(
			String edatdinicipatologiarespiratoriaanys) {
		Edatdinicipatologiarespiratoriaanys = edatdinicipatologiarespiratoriaanys;
	}

	public String getSímptomesintercrisisasma() {
		return Símptomesintercrisisasma;
	}

	public void setSímptomesintercrisisasma(String símptomesintercrisisasma) {
		Símptomesintercrisisasma = símptomesintercrisisasma;
	}

	public String getCANControlAsmaNens07puntsboncontrol() {
		return CANControlAsmaNens07puntsboncontrol;
	}

	public void setCANControlAsmaNens07puntsboncontrol(
			String cANControlAsmaNens07puntsboncontrol) {
		CANControlAsmaNens07puntsboncontrol = cANControlAsmaNens07puntsboncontrol;
	}

	public String getFreqüènciacrisisasma() {
		return Freqüènciacrisisasma;
	}

	public void setFreqüènciacrisisasma(String freqüènciacrisisasma) {
		Freqüènciacrisisasma = freqüènciacrisisasma;
	}

	public String getIngresosperasma() {
		return Ingresosperasma;
	}

	public void setIngresosperasma(String ingresosperasma) {
		Ingresosperasma = ingresosperasma;
	}

	public String getTractamentdebaseperlasma() {
		return Tractamentdebaseperlasma;
	}

	public void setTractamentdebaseperlasma(String tractamentdebaseperlasma) {
		Tractamentdebaseperlasma = tractamentdebaseperlasma;
	}

	public String getAcaros() {
		return acaros;
	}

	public void setAcaros(String acaros) {
		this.acaros = acaros;
	}

	public String getBudesonida() {
		return budesonida;
	}

	public void setBudesonida(String budesonida) {
		this.budesonida = budesonida;
	}

	public String getFluticasona() {
		return fluticasona;
	}

	public void setFluticasona(String fluticasona) {
		this.fluticasona = fluticasona;
	}

	public String getCiclesonida() {
		return ciclesonida;
	}

	public void setCiclesonida(String ciclesonida) {
		this.ciclesonida = ciclesonida;
	}

	public String getMometasona() {
		return mometasona;
	}

	public void setMometasona(String mometasona) {
		this.mometasona = mometasona;
	}

	public String getMontelukast() {
		return montelukast;
	}

	public void setMontelukast(String montelukast) {
		this.montelukast = montelukast;
	}

	public String getSingulair() {
		return singulair;
	}

	public void setSingulair(String singulair) {
		this.singulair = singulair;
	}

	public String getSalmeterolfluticasona() {
		return salmeterolfluticasona;
	}

	public void setSalmeterolfluticasona(String salmeterolfluticasona) {
		this.salmeterolfluticasona = salmeterolfluticasona;
	}

	public String getFormoterolbudesonida() {
		return formoterolbudesonida;
	}

	public void setFormoterolbudesonida(String formoterolbudesonida) {
		this.formoterolbudesonida = formoterolbudesonida;
	}

	public String getOmalizumab() {
		return omalizumab;
	}

	public void setOmalizumab(String omalizumab) {
		this.omalizumab = omalizumab;
	}

	public String getFumadorsaldomicilihabitual() {
		return Fumadorsaldomicilihabitual;
	}

	public void setFumadorsaldomicilihabitual(String fumadorsaldomicilihabitual) {
		Fumadorsaldomicilihabitual = fumadorsaldomicilihabitual;
	}

	public String getMedicacióderescat() {
		return Medicacióderescat;
	}

	public void setMedicacióderescat(String medicacióderescat) {
		Medicacióderescat = medicacióderescat;
	}

	public String getAntecedentsfamiliarsdatòpia() {
		return Antecedentsfamiliarsdatòpia;
	}

	public void setAntecedentsfamiliarsdatòpia(
			String antecedentsfamiliarsdatòpia) {
		Antecedentsfamiliarsdatòpia = antecedentsfamiliarsdatòpia;
	}

	public String getDispneanocturna() {
		return Dispneanocturna;
	}

	public void setDispneanocturna(String dispneanocturna) {
		Dispneanocturna = dispneanocturna;
	}

	public String getImmunoteràpia() {
		return Immunoteràpia;
	}

	public void setImmunoteràpia(String immunoteràpia) {
		Immunoteràpia = immunoteràpia;
	}

	public String getCrisisdasma() {
		return Crisisdasma;
	}

	public void setCrisisdasma(String crisisdasma) {
		Crisisdasma = crisisdasma;
	}

	public String getSímptomésambesforç() {
		return Símptomésambesforç;
	}

	public void setSímptomésambesforç(String símptomésambesforç) {
		Símptomésambesforç = símptomésambesforç;
	}

	public void setListaCampos(List<String> listeChamps) {
		this.listaCampos = listeChamps;
	}

	public String getFechaini() {
		return fechaini;
	}

	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

	public boolean isSimptomesIntercrisisAsma() {
		return simptomesIntercrisisAsma;
	}

	public void setSimptomesIntercrisisAsma(boolean simptomesIntercrisisAsma) {
		this.simptomesIntercrisisAsma = simptomesIntercrisisAsma;
	}

	public boolean isCrisisAsma() {
		return crisisAsma;
	}

	public void setCrisisAsma(boolean crisisAsma) {
		this.crisisAsma = crisisAsma;
	}

	public boolean isTotesUrgenciesPrediccio() {
		return totesUrgenciesPrediccio;
	}

	public void setTotesUrgenciesPrediccio(boolean totesUrgenciesPrediccio) {
		this.totesUrgenciesPrediccio = totesUrgenciesPrediccio;
	}

	public String getFEV1() {
		return FEV1;
	}

	public void setFEV1(String fEV1) {
		FEV1 = fEV1;
	}

	public String getFEF2575() {
		return FEF2575;
	}

	public void setFEF2575(String fEF2575) {
		FEF2575 = fEF2575;
	}

	public String getTotesUrgencies() {
		return totesUrgencies;
	}

	public void setTotesUrgencies(String totesUrgencies) {
		this.totesUrgencies = totesUrgencies;
	}

	public double getPorcentajeCrisisAsma() {
		return porcentajeCrisisAsma;
	}

	public void setPorcentajeCrisisAsma(double porcentajeCrisisAsma) {
		this.porcentajeCrisisAsma = porcentajeCrisisAsma;
	}

	public double getPorcentajeTotesUrgencies() {
		return porcentajeTotesUrgencies;
	}

	public void setPorcentajeTotesUrgencies(double porcentajeTotesUrgencies) {
		this.porcentajeTotesUrgencies = porcentajeTotesUrgencies;
	}

	public double getPorcentajeSimtomesIntercrisisAsma() {
		return porcentajeSimtomesIntercrisisAsma;
	}

	public void setPorcentajeSimtomesIntercrisisAsma(
			double porcentajeSimtomesIntercrisisAsma) {
		this.porcentajeSimtomesIntercrisisAsma = porcentajeSimtomesIntercrisisAsma;
	}

}
