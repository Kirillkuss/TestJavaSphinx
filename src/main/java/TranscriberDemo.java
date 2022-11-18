import edu.cmu.sphinx.alignment.LongTextAligner;
import edu.cmu.sphinx.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TranscriberDemo {
    private static String ACOUSTIC_MODELS = "file:///C:/zero/zero_ru.cd_cont_4000";
    private static String LANGUAGE_MODEL  = "file:///C:/zero/ru.lm";
    private static String DICTIONARY      = "file:///C:/zero/ru.dic";
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath( ACOUSTIC_MODELS );
        configuration.setDictionaryPath( DICTIONARY );
        configuration.setLanguageModelPath( LANGUAGE_MODEL );
        configuration.setSampleRate(8000);
        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer( configuration );
        InputStream stream = new FileInputStream(new File("D://Project/TestJavaSphinx/src/main/resources/decoder-test.wav"));
        recognizer.startRecognition(stream);
        SpeechResult result ;
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Результат: %s\n", result.getHypothesis());
        }
        recognizer.stopRecognition();
    }
}
