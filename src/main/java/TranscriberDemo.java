import edu.cmu.sphinx.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TranscriberDemo {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration.setSampleRate(12000);
        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);

        InputStream stream = new FileInputStream(new File("E://JAVA/TestJavaSphinx/src/main/resources/terminator.wav"));
        recognizer.startRecognition(stream);
        SpeechResult result ;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Expectation: I'll be back....at the exit: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }
}
