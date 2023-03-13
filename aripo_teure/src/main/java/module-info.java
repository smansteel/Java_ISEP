module info.tardieu.maxime.aripo_teure {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.xml;

    opens info.tardieu.maxime.aripo_teure to javafx.fxml;
    exports info.tardieu.maxime.aripo_teure;
}