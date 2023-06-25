module com.jfx.xmloutput.xmloutputfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.xml.bind;

    opens com.jfx.xmloutput.xmloutputfx;
    exports com.jfx.xmloutput.xmloutputfx;
}