package code;

import java.io.File;
import java.io.IOException;

import gate.CorpusController;
import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.LanguageAnalyser;
import gate.ProcessingResource;
import gate.creole.ANNIEConstants;
import gate.creole.SerialAnalyserController;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;

public class GetCCForKeywords {

	public static CorpusController createController() throws GateException, IOException {
		
		Gate.getCreoleRegister().registerDirectories(
				new File(Gate.getPluginsHome(), "Tools").toURI().toURL());
		
		SerialAnalyserController controller = (SerialAnalyserController) 
				PersistenceManager.loadObjectFromFile(new File(new File( 
				Gate.getPluginsHome(), ANNIEConstants.PLUGIN_DIR),ANNIEConstants.DEFAULT_FILE));
				
		controller.remove(2);  			// removing the default gazetteer
		controller.remove(5);			// removing ANNIE NE Transducer
		controller.remove(4);			// removing ANNIE Orthomatcher
		
		FeatureMap paramsg = Factory.newFeatureMap();  
		paramsg.put("listsURL", new File("resources/Rules/keywords.def").toURI().toURL());  
		paramsg.put("caseSensitive", false);
		LanguageAnalyser mainGazetteer = (LanguageAnalyser)Factory.createResource(  
		     "gate.creole.gazetteer.DefaultGazetteer", paramsg);
			
		controller.add(3,mainGazetteer);
		
		FeatureMap params = Factory.newFeatureMap();  
		params.put("grammarURL", new File("resources/Rules/MainKeywordsExtract.jape").toURI().toURL());  
		ProcessingResource transducer = (ProcessingResource)Factory.createResource(  
		     "gate.jape.plus.Transducer", params);
	
		controller.add(transducer);
		
		return controller;
	}
}