package net.viralpatel.struts2.action;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import twitter4j.TwitterException;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private List<String> listaCampos;

	private String username;

	private String password;

	private List<Tweet> listeTweets;

	private int totalTrue;

	private int totalFalse;

	// TODOS LOS ATRIBUTOS TOMADOS EN CUENTA EN LA CLASIFICACION
	private String fechaini;
	private String edad;
	private String codigopoblacion;
	private String Enlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat;
	private String Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit;
	private String Altresmanifestacionsdatòpia;
	private String Edatdinicipatologiarespiratoriaanys;
	private String Antecedentspersonals;
	private String Enlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma;
	private String Símptomesintercrisisasma;
	private String CANControlAsmaNens07puntsboncontrol;
	private String Enlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit;
	private String Desencadenants;
	private String Moquetescatifesendomicilihabitual;
	private String Visitesaurgències;
	private String Freqüènciacrisisasma;
	private String Ingresosperasma;
	private String Tractamentdebaseperlasma;
	private String asma;
	private String rinitis;
	private String acaros;
	private String alergia;
	private String rinoconjuntivitis;
	private String budesonida;
	private String fluticasona;
	private String ciclesonida;
	private String mometasona;
	private String montelukast;
	private String singulair;
	private String salmeterolfluticasona;
	private String formoterolbudesonida;
	private String omalizumab;
	private String ocs;
	private String salbutamol;
	private String Tossibilàncies;
	private String Símptomesderinoconjuntivitis;
	private String Fumadorsaldomicilihabitual;
	private String Medicacióderescat;
	private String Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia;
	private String Respostaabroncodilatadors;
	private String Dispneadiurna;
	private String Enlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos;
	private String Estacionalitat;
	private String Enlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma;
	private String evolucioPatologia;
	private String Antecedentsfamiliarsdatòpia;
	private String ReaccionsalaITE;
	private String Enlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat;
	private String Altresantecedentsfamiliarsdinterès;
	private String Dispneanocturna;
	private String Immunoteràpia;
	private String Crisisdasma;
	private String pis;
	private String humed;
	private String casa;
	private String ventilad;
	private String solead;
	private String peluches;
	private String Enlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia;
	private String Animalsaldomicilihabitual;
	private String Tractamentdebaseperlarinitis;
	private String Faltesescolars;
	private String Símptomésambesforç;
	private String numurgenciasnecesitandoingres;
	private String numurgenciasnecesitandoingresno;

	public String execute() {

		if (null != this.username) {

			String s = processArffLine();
			
			ArffWriter.write(s);
			
			List<double[]> predictions = WekaPredictor.classify();
			double predictTrue = predictions.get(0)[1];
			if (predictTrue > 0.95) {
				totalTrue++;
			} else {
				totalFalse++;
			}
			return "success";
		}

		else {
			addActionError(getText("error.login"));
			return "error";
		}

	}

	private String processArffLine() {
		return "";
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

	public String getEnlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat() {
		return Enlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat;
	}

	public void setEnlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat(
			String enlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat) {
		Enlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat = enlesdarreres4setmanesambquinafreqüènciahatositduranteldiaenausènciaderefredat;
	}

	public String getEnlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit() {
		return Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit;
	}

	public void setEnlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit(
			String enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit) {
		Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit = enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasperlanit;
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

	public String getAntecedentspersonals() {
		return Antecedentspersonals;
	}

	public void setAntecedentspersonals(String antecedentspersonals) {
		Antecedentspersonals = antecedentspersonals;
	}

	public String getEnlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma() {
		return Enlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma;
	}

	public void setEnlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma(
			String enlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma) {
		Enlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma = enlesdarreres4setmanesquantesvegadeshaingresatenelhospitalacausadelasma;
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

	public String getEnlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit() {
		return Enlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit;
	}

	public void setEnlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit(
			String enlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit) {
		Enlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit = enlesdarreres4setmanesAmbquinafreqüènciahatingutxiuletsosibilànciesdurantlanit;
	}

	public String getDesencadenants() {
		return Desencadenants;
	}

	public void setDesencadenants(String desencadenants) {
		Desencadenants = desencadenants;
	}

	public String getMoquetescatifesendomicilihabitual() {
		return Moquetescatifesendomicilihabitual;
	}

	public void setMoquetescatifesendomicilihabitual(
			String moquetescatifesendomicilihabitual) {
		Moquetescatifesendomicilihabitual = moquetescatifesendomicilihabitual;
	}

	public String getVisitesaurgències() {
		return Visitesaurgències;
	}

	public void setVisitesaurgències(String visitesaurgències) {
		Visitesaurgències = visitesaurgències;
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

	public String getAsma() {
		return asma;
	}

	public void setAsma(String asma) {
		this.asma = asma;
	}

	public String getRinitis() {
		return rinitis;
	}

	public void setRinitis(String rinitis) {
		this.rinitis = rinitis;
	}

	public String getAcaros() {
		return acaros;
	}

	public void setAcaros(String acaros) {
		this.acaros = acaros;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getRinoconjuntivitis() {
		return rinoconjuntivitis;
	}

	public void setRinoconjuntivitis(String rinoconjuntivitis) {
		this.rinoconjuntivitis = rinoconjuntivitis;
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

	public String getOcs() {
		return ocs;
	}

	public void setOcs(String ocs) {
		this.ocs = ocs;
	}

	public String getSalbutamol() {
		return salbutamol;
	}

	public void setSalbutamol(String salbutamol) {
		this.salbutamol = salbutamol;
	}

	public String getTossibilàncies() {
		return Tossibilàncies;
	}

	public void setTossibilàncies(String tossibilàncies) {
		Tossibilàncies = tossibilàncies;
	}

	public String getSímptomesderinoconjuntivitis() {
		return Símptomesderinoconjuntivitis;
	}

	public void setSímptomesderinoconjuntivitis(
			String símptomesderinoconjuntivitis) {
		Símptomesderinoconjuntivitis = símptomesderinoconjuntivitis;
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

	public String getEnlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia() {
		return Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia;
	}

	public void setEnlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia(
			String enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia) {
		Enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia = enlesdarreres4setmanesambquinafreqüèncialihacostatrespirarnopelnasduranteldia;
	}

	public String getRespostaabroncodilatadors() {
		return Respostaabroncodilatadors;
	}

	public void setRespostaabroncodilatadors(String respostaabroncodilatadors) {
		Respostaabroncodilatadors = respostaabroncodilatadors;
	}

	public String getDispneadiurna() {
		return Dispneadiurna;
	}

	public void setDispneadiurna(String dispneadiurna) {
		Dispneadiurna = dispneadiurna;
	}

	public String getEnlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos() {
		return Enlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos;
	}

	public void setEnlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos(
			String enlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos) {
		Enlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos = enlesdarreres4setmanesquanfaelnenexercicioesriuarialladestexiuletsotos;
	}

	public String getEstacionalitat() {
		return Estacionalitat;
	}

	public void setEstacionalitat(String estacionalitat) {
		Estacionalitat = estacionalitat;
	}

	public String getEnlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma() {
		return Enlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma;
	}

	public void setEnlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma(
			String enlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma) {
		Enlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma = enlesdarreres4setmanesquantsdieshavingutaurgènciesacausadelasma;
	}

	public String getEvolucioPatologia() {
		return evolucioPatologia;
	}

	public void setEvolucioPatologia(String evolucioPatologia) {
		this.evolucioPatologia = evolucioPatologia;
	}

	public String getAntecedentsfamiliarsdatòpia() {
		return Antecedentsfamiliarsdatòpia;
	}

	public void setAntecedentsfamiliarsdatòpia(
			String antecedentsfamiliarsdatòpia) {
		Antecedentsfamiliarsdatòpia = antecedentsfamiliarsdatòpia;
	}

	public String getReaccionsalaITE() {
		return ReaccionsalaITE;
	}

	public void setReaccionsalaITE(String reaccionsalaITE) {
		ReaccionsalaITE = reaccionsalaITE;
	}

	public String getEnlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat() {
		return Enlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat;
	}

	public void setEnlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat(
			String enlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat) {
		Enlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat = enlesdarreres4setmanesambquinafreqüènciahatositdurantlanitenausènciaderefredat;
	}

	public String getAltresantecedentsfamiliarsdinterès() {
		return Altresantecedentsfamiliarsdinterès;
	}

	public void setAltresantecedentsfamiliarsdinterès(
			String altresantecedentsfamiliarsdinterès) {
		Altresantecedentsfamiliarsdinterès = altresantecedentsfamiliarsdinterès;
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

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getHumed() {
		return humed;
	}

	public void setHumed(String humed) {
		this.humed = humed;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public String getVentilad() {
		return ventilad;
	}

	public void setVentilad(String ventilad) {
		this.ventilad = ventilad;
	}

	public String getSolead() {
		return solead;
	}

	public void setSolead(String solead) {
		this.solead = solead;
	}

	public String getPeluches() {
		return peluches;
	}

	public void setPeluches(String peluches) {
		this.peluches = peluches;
	}

	public String getEnlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia() {
		return Enlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia;
	}

	public void setEnlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia(
			String enlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia) {
		Enlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia = enlesdarreres4setmanesambquinafreqüènciahatingutxiuletsosibilànciesduranteldia;
	}

	public String getAnimalsaldomicilihabitual() {
		return Animalsaldomicilihabitual;
	}

	public void setAnimalsaldomicilihabitual(String animalsaldomicilihabitual) {
		Animalsaldomicilihabitual = animalsaldomicilihabitual;
	}

	public String getTractamentdebaseperlarinitis() {
		return Tractamentdebaseperlarinitis;
	}

	public void setTractamentdebaseperlarinitis(
			String tractamentdebaseperlarinitis) {
		Tractamentdebaseperlarinitis = tractamentdebaseperlarinitis;
	}

	public String getFaltesescolars() {
		return Faltesescolars;
	}

	public void setFaltesescolars(String faltesescolars) {
		Faltesescolars = faltesescolars;
	}

	public String getSímptomésambesforç() {
		return Símptomésambesforç;
	}

	public void setSímptomésambesforç(String símptomésambesforç) {
		Símptomésambesforç = símptomésambesforç;
	}

	public String getNumurgenciasnecesitandoingres() {
		return numurgenciasnecesitandoingres;
	}

	public void setNumurgenciasnecesitandoingres(
			String numurgenciasnecesitandoingres) {
		this.numurgenciasnecesitandoingres = numurgenciasnecesitandoingres;
	}

	public String getNumurgenciasnecesitandoingresno() {
		return numurgenciasnecesitandoingresno;
	}

	public void setNumurgenciasnecesitandoingresno(
			String numurgenciasnecesitandoingresno) {
		this.numurgenciasnecesitandoingresno = numurgenciasnecesitandoingresno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tweet> getListeTweets() {
		return listeTweets;
	}

	public void setListeTweets(List<Tweet> listeTweets) {
		this.listeTweets = listeTweets;
	}

	public int getTotalTrue() {
		return totalTrue;
	}

	public void setTotalTrue(int totalTrue) {
		this.totalTrue = totalTrue;
	}

	public int getTotalFalse() {
		return totalFalse;
	}

	public void setTotalFalse(int totalFalse) {
		this.totalFalse = totalFalse;
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

	public void setListaCampos(List<String> listeChamps) {
		this.listaCampos = listeChamps;
	}

	public String getFechaini() {
		return fechaini;
	}

	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

}
