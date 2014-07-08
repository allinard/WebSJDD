package net.viralpatel.struts2.action;

// Generated with Weka 3.6.10
//
// This code is public domain and comes with no warranty.
//
// Timestamp: Tue Feb 04 12:53:33 CET 2014


import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;

public class WekaWrapper
  extends Classifier {

  /**
   * Returns only the toString() method.
   *
   * @return a string describing the classifier
   */
  public String globalInfo() {
    return toString();
  }

  /**
   * Returns the capabilities of this classifier.
   *
   * @return the capabilities
   */
  public Capabilities getCapabilities() {
    weka.core.Capabilities result = new weka.core.Capabilities(this);

    result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
    result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
    result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
    result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);

    result.setMinimumNumberInstances(0);

    return result;
  }

  /**
   * only checks the data against its capabilities.
   *
   * @param i the training data
   */
  public void buildClassifier(Instances i) throws Exception {
    // can classifier handle the data?
    getCapabilities().testWithFail(i);
  }

  /**
   * Classifies the given instance.
   *
   * @param i the instance to classify
   * @return the classification result
   */
//  public double classifyInstance(Instance i) throws Exception {
//    Object[] s = new Object[i.numAttributes()];
//    
//    for (int j = 0; j < s.length; j++) {
//      if (!i.isMissing(j)) {
//        if (i.attribute(j).isNominal())
//          s[j] = new String(i.stringValue(j));
//        else if (i.attribute(j).isNumeric())
//          s[j] = new Double(i.value(j));
//      }
//    }
//    
//    // set class value to missing
//    s[i.classIndex()] = null;
//    
//    return WekaClassifier.classify(s);
//  }

  /**
   * Returns the revision string.
   * 
   * @return        the revision
   */
  public String getRevision() {
    return RevisionUtils.extract("1.0");
  }

  /**
   * Returns only the classnames and what classifier it is based on.
   *
   * @return a short description
   */
  public String toString() {
    return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.6.10).\n" + this.getClass().getName() + "/WekaClassifier";
  }

  /**
   * Runs the classfier from commandline.
   *
   * @param args the commandline arguments
   */
  public static void main(String args[]) {
    runClassifier(new WekaWrapper(), args);
  }
}

class WekaClassifier {

  public static double classify(String arff)
    throws Exception {
	
	String[] i;
	i = arff.split(",");
	  
    double p = Double.NaN;
    p = WekaClassifier.N49b1030(i);
    return p;
  }
  static double N49b1030(Object []i) {
    double p = Double.NaN;
    if (i[0] == null) {
      p = 0;
    } else if (i[0].equals("true")) {
      p = 0;
    } else if (i[0].equals("false")) {
    p = WekaClassifier.N45df41(i);
    } 
    return p;
  }
  static double N45df41(Object []i) {
    double p = Double.NaN;
    if (i[1] == null) {
      p = 0;
    } else if (i[1].equals("true")) {
    p = WekaClassifier.Nb479ad2(i);
    } else if (i[1].equals("false")) {
    p = WekaClassifier.Na0732c3(i);
    } 
    return p;
  }
  static double Nb479ad2(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 1;
    } else if (i[6].equals("true")) {
      p = 1;
    } else if (i[6].equals("false")) {
      p = 0;
    } 
    return p;
  }
  static double Na0732c3(Object []i) {
    double p = Double.NaN;
    if (i[6] == null) {
      p = 1;
    } else if (i[6].equals("true")) {
      p = 1;
    } else if (i[6].equals("false")) {
    p = WekaClassifier.N1e955344(i);
    } 
    return p;
  }
  static double N1e955344(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 135.0) {
    p = WekaClassifier.N1d8edce5(i);
    } else if (Double.valueOf((String) i[8]) > 135.0) {
    p = WekaClassifier.N14dab0430(i);
    } 
    return p;
  }
  static double N1d8edce5(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 993.0) {
    p = WekaClassifier.Ne483d26(i);
    } else if (Double.valueOf((String) i[7]) > 993.0) {
      p = 0;
    } 
    return p;
  }
  static double Ne483d26(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 1.0) {
    p = WekaClassifier.N8a59ae7(i);
    } else if (Double.valueOf((String) i[7]) > 1.0) {
    p = WekaClassifier.N4d26f918(i);
    } 
    return p;
  }
  static double N8a59ae7(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 1;
    } else if (i[5].equals("absent")) {
    p = WekaClassifier.N105dbeb8(i);
    } else if (i[5].equals("regulier")) {
    p = WekaClassifier.N188cb3b11(i);
    } else if (i[5].equals("surnombre")) {
    p = WekaClassifier.N10a833a14(i);
    } 
    return p;
  }
  static double N105dbeb8(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 131.0) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) > 131.0) {
    p = WekaClassifier.N1a954179(i);
    } 
    return p;
  }
  static double N1a954179(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (i[3].equals("true")) {
      p = 1;
    } else if (i[3].equals("false")) {
    p = WekaClassifier.N1cfbd1d10(i);
    } 
    return p;
  }
  static double N1cfbd1d10(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 0.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 0.0) {
      p = 1;
    } 
    return p;
  }
  static double N188cb3b11(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (i[3].equals("true")) {
      p = 1;
    } else if (i[3].equals("false")) {
    p = WekaClassifier.N1d6cfe612(i);
    } 
    return p;
  }
  static double N1d6cfe612(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 0.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 0.0) {
    p = WekaClassifier.N1eb3d6013(i);
    } 
    return p;
  }
  static double N1eb3d6013(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 126.0) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) > 126.0) {
      p = 1;
    } 
    return p;
  }
  static double N10a833a14(Object []i) {
    double p = Double.NaN;
    if (i[3] == null) {
      p = 1;
    } else if (i[3].equals("true")) {
    p = WekaClassifier.N12d7b5315(i);
    } else if (i[3].equals("false")) {
    p = WekaClassifier.Nfb962216(i);
    } 
    return p;
  }
  static double N12d7b5315(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 107.0) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) > 107.0) {
      p = 0;
    } 
    return p;
  }
  static double Nfb962216(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 0.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 0.0) {
    p = WekaClassifier.N13dc4f217(i);
    } 
    return p;
  }
  static double N13dc4f217(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 109.0) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) > 109.0) {
      p = 1;
    } 
    return p;
  }
  static double N4d26f918(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 76.0) {
    p = WekaClassifier.N139d4c619(i);
    } else if (Double.valueOf((String) i[7]) > 76.0) {
    p = WekaClassifier.N1671ce727(i);
    } 
    return p;
  }
  static double N139d4c619(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 121.0) {
    p = WekaClassifier.N1c03ac620(i);
    } else if (Double.valueOf((String) i[8]) > 121.0) {
    p = WekaClassifier.N1824e7024(i);
    } 
    return p;
  }
  static double N1c03ac620(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 47.0) {
    p = WekaClassifier.N152a53e21(i);
    } else if (Double.valueOf((String) i[8]) > 47.0) {
      p = 1;
    } 
    return p;
  }
  static double N152a53e21(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 10.0) {
    p = WekaClassifier.Nde946122(i);
    } else if (Double.valueOf((String) i[7]) > 10.0) {
      p = 1;
    } 
    return p;
  }
  static double Nde946122(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 41.0) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) > 41.0) {
    p = WekaClassifier.Ndfa00323(i);
    } 
    return p;
  }
  static double Ndfa00323(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 4.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 4.0) {
      p = 0;
    } 
    return p;
  }
  static double N1824e7024(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 13.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 13.0) {
    p = WekaClassifier.N1eb9ff025(i);
    } 
    return p;
  }
  static double N1eb9ff025(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 130.0) {
    p = WekaClassifier.N516b7a26(i);
    } else if (Double.valueOf((String) i[8]) > 130.0) {
      p = 1;
    } 
    return p;
  }
  static double N516b7a26(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 33.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 33.0) {
      p = 1;
    } 
    return p;
  }
  static double N1671ce727(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 1;
    } else if (i[5].equals("absent")) {
    p = WekaClassifier.N9a9d1528(i);
    } else if (i[5].equals("regulier")) {
    p = WekaClassifier.Nbed00f29(i);
    } else if (i[5].equals("surnombre")) {
      p = 1;
    } 
    return p;
  }
  static double N9a9d1528(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 181.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 181.0) {
      p = 1;
    } 
    return p;
  }
  static double Nbed00f29(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 883.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 883.0) {
      p = 0;
    } 
    return p;
  }
  static double N14dab0430(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 1.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 1.0) {
    p = WekaClassifier.N16d3e031(i);
    } 
    return p;
  }
  static double N16d3e031(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 291.0) {
    p = WekaClassifier.Nb053b132(i);
    } else if (Double.valueOf((String) i[7]) > 291.0) {
      p = 0;
    } 
    return p;
  }
  static double Nb053b132(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 2.0) {
    p = WekaClassifier.N46b4e733(i);
    } else if (Double.valueOf((String) i[7]) > 2.0) {
    p = WekaClassifier.Neabe234(i);
    } 
    return p;
  }
  static double N46b4e733(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 136.0) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) > 136.0) {
      p = 1;
    } 
    return p;
  }
  static double Neabe234(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 91.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 91.0) {
    p = WekaClassifier.N136a24235(i);
    } 
    return p;
  }
  static double N136a24235(Object []i) {
    double p = Double.NaN;
    if (i[5] == null) {
      p = 0;
    } else if (i[5].equals("absent")) {
    p = WekaClassifier.N1d6b65936(i);
    } else if (i[5].equals("regulier")) {
      p = 1;
    } else if (i[5].equals("surnombre")) {
      p = 1;
    } 
    return p;
  }
  static double N1d6b65936(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 138.0) {
    p = WekaClassifier.N15d984237(i);
    } else if (Double.valueOf((String) i[8]) > 138.0) {
    p = WekaClassifier.Nb744eb40(i);
    } 
    return p;
  }
  static double N15d984237(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 134.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 134.0) {
    p = WekaClassifier.N1b7379b38(i);
    } 
    return p;
  }
  static double N1b7379b38(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[8]) <= 136.0) {
    p = WekaClassifier.N1a3bcaa39(i);
    } else if (Double.valueOf((String) i[8]) > 136.0) {
      p = 1;
    } 
    return p;
  }
  static double N1a3bcaa39(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 197.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 197.0) {
      p = 0;
    } 
    return p;
  }
  static double Nb744eb40(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 154.0) {
    p = WekaClassifier.Ndc49241(i);
    } else if (Double.valueOf((String) i[7]) > 154.0) {
      p = 0;
    } 
    return p;
  }
  static double Ndc49241(Object []i) {
    double p = Double.NaN;
    if (i[8] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[8]) <= 139.0) {
    p = WekaClassifier.N1e462cf42(i);
    } else if (Double.valueOf((String) i[8]) > 139.0) {
    p = WekaClassifier.N1133c6643(i);
    } 
    return p;
  }
  static double N1e462cf42(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) <= 105.0) {
      p = 1;
    } else if (Double.valueOf((String) i[7]) > 105.0) {
      p = 0;
    } 
    return p;
  }
  static double N1133c6643(Object []i) {
    double p = Double.NaN;
    if (i[7] == null) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) <= 127.0) {
      p = 0;
    } else if (Double.valueOf((String) i[7]) > 127.0) {
      p = 1;
    } 
    return p;
  }
}
