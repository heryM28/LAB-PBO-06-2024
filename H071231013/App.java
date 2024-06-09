package mangalik;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
        private Stage stage;

        public static void main(String[] args) {
                launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
                stage = primaryStage;
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/awal.jpg")));
                scene1();
                stage.show();
        }

        private void scene1() {
                Image backgroundImage = new Image(getClass().getResourceAsStream("/awal.jpg"));
                BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false,
                                false, true, false);
                BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

                Label label = new Label("");
                label.setStyle("-fx-font-family: 'Sans-Serif'; -fx-font-size: 30px; -fx-font-weight: bold;");
                label.setTextFill(Color.WHITE);
                HBox hBox1 = new HBox(label);
                hBox1.setAlignment(Pos.CENTER);

                Button button = new Button("OPEN");
                button.setStyle("-fx-background-color: #008000; -fx-font-family: 'Sans-Serif'; -fx-font-weight: bold; -fx-padding: 10px 90px; -fx-height: 3px 50px; -fx-font-size: 10px; -fx-border-color: BLACK; -fx-border-width: 1px; -fx-border-radius: 3;");
                button.setTextFill(Color.WHITE);
                button.setOnAction(v -> {
                        createHomeScene();
                });
                HBox hBox3 = new HBox(button);
                hBox3.setAlignment(Pos.CENTER);

                VBox vBox = new VBox(20, hBox1, hBox3);
                vBox.setAlignment(Pos.CENTER);

                StackPane root = new StackPane();
                root.getChildren().add(vBox);
                root.setBackground(new Background(background));

                Scene scene1 = new Scene(root, 690, 400);
                stage.setTitle("homepage");
                stage.setScene(scene1);
        }

        private void createHomeScene() {
                VBox mainVBox = new VBox(10);
                mainVBox.setAlignment(Pos.TOP_CENTER);
                mainVBox.setStyle("-fx-background-color: white;");

                // Menambahkan item berita
                addNewsItem(mainVBox, "inet.detik.com", "Curhatan Kevin Sanjaya Bikin Warganet Emosi pada PBSI", "2h",
                                32, 10, "/kevin.jpg");
                addNewsItem(mainVBox, "trends.tribunnews.com",
                                "Innalillahi, Rini AFI Meninggal Dunia, Diduga Sakit, Tangis para Sahabat di Makam: 'Sel...",
                                "2h", 3, 4, "/rini.jpg");
                addNewsItem(mainVBox, "liputan 6", "Jokowi Sebar Bansos hingga Desember, PDIP: Cawe-cawe untuk Pilkada",
                                "2h", 4, 6, "/jokowi.jpg");
                addNewsItem(mainVBox, "trends.tribunnews.com",
                                "Curhat Produser Film 'Vina: Sebelum 7 Hari', Ngaku Diancam Oknum Polisi, Minta...",
                                "2h", 30, 4, "/vina.jpg");

                // Menambahkan tombol navigasi di bawah
                HBox navigationBar = new HBox(20);
                navigationBar.setAlignment(Pos.CENTER);
                navigationBar.setStyle("-fx-background-color: #F8F8F8; -fx-padding: 10px;");

                // Tombol Beranda
                Button homeButton = new Button("Beranda",
                                new ImageView(new Image(getClass().getResourceAsStream("/beranda.jpg"))));
                homeButton.setContentDisplay(ContentDisplay.TOP);
                homeButton.setStyle(
                                "-fx-font-family: 'Sans-Serif';" +
                                                "-fx-font-size: 16px;" + // Ukuran font
                                                "-fx-pref-width: 10px;" + // Lebar tombol
                                                "-fx-pref-height: 10px;" + // Tinggi tombol
                                                "-fx-padding: 10px 0px;" // Padding atas dan bawah
                );
                homeButton.setOnAction(v -> scene1());

                // Tombol Video
                Button videoButton = new Button("Video",
                                new ImageView(new Image(getClass().getResourceAsStream("/video.jpg"))));
                videoButton.setContentDisplay(ContentDisplay.TOP);
                videoButton.setStyle(
                                "-fx-font-family: 'Sans-Serif';" +
                                                "-fx-font-size: 16px;" +
                                                "-fx-pref-width: 100px;" +
                                                "-fx-pref-height: 100px;" +
                                                "-fx-padding: 10px 0px;");

                // Tombol Klip
                Button clipButton = new Button("Klip",
                                new ImageView(new Image(getClass().getResourceAsStream("/clip.jpg"))));
                clipButton.setContentDisplay(ContentDisplay.TOP);
                clipButton.setStyle(
                                "-fx-font-family: 'Arial';" +
                                                "-fx-font-size: 16px;" +
                                                "-fx-pref-width: 100px;" +
                                                "-fx-pref-height: 100px;" +
                                                "-fx-padding: 10px 0px;");

                // Tombol Saya
                Button profileButton = new Button("Saya",
                                new ImageView(new Image(getClass().getResourceAsStream("/profil.jpg"))));
                profileButton.setContentDisplay(ContentDisplay.TOP);
                profileButton.setStyle(
                                "-fx-font-family: 'Sans-Serif';" +
                                                "-fx-font-size: 16px;" +
                                                "-fx-pref-width: 100px;" +
                                                "-fx-pref-height: 100px;" +
                                                "-fx-padding: 10px 0px;");
                profileButton.setOnAction(v -> createProfileScene());

                navigationBar.getChildren().addAll(homeButton, videoButton, clipButton, profileButton);

                BorderPane root = new BorderPane();
                root.setCenter(mainVBox);
                root.setBottom(navigationBar);

                Scene scene = new Scene(root, 690, 400);
                stage.setTitle("Beranda");
                stage.setScene(scene);
        }

        private void createProfileScene() {
                VBox profileVBox = new VBox(10);
                profileVBox.setAlignment(Pos.CENTER);
                profileVBox.setStyle("-fx-background-color: white; -fx-padding: 20px;");

                // Informasi profil
                ImageView profileImageView = new ImageView(new Image(getClass().getResourceAsStream("/mobil.jpg")));
                profileImageView.setFitWidth(500);
                profileImageView.setFitHeight(500);
                profileImageView.setPreserveRatio(true);

                Label nameLabel = new Label("Nama: Mangalik");
                nameLabel.setFont(Font.font("Arial", 18));

                Label nimLabel = new Label("NIM: H071231013");
                nimLabel.setFont(Font.font("Arial", 18));

                Label schoolLabel = new Label(" Universitas Hasanuddin");
                schoolLabel.setFont(Font.font("Arial", 18));

                profileVBox.getChildren().addAll(profileImageView, nameLabel, nimLabel, schoolLabel);

                // Tombol kembali
                Button backButton = new Button("BACK");
                backButton.setOnAction(v -> createHomeScene());
                profileVBox.getChildren().add(backButton);

                Scene profileScene = new Scene(profileVBox, 690, 400);
                stage.setTitle("Profil Saya");
                stage.setScene(profileScene);
        }

        private void addNewsItem(VBox parent, String source, String title, String time, int likes, int comments,
                        String imagePath) {
                VBox newsItemVBox = new VBox(5);
                newsItemVBox.setAlignment(Pos.CENTER_LEFT);
                newsItemVBox.setStyle("-fx-padding: 10px; -fx-border-color: #E0E0E0; -fx-border-width: 0 0 1px 0;");

                Label sourceLabel = new Label(source);
                sourceLabel.setFont(Font.font("Arial", 12));
                sourceLabel.setTextFill(Color.GRAY);

                Label titleLabel = new Label(title);
                titleLabel.setFont(Font.font("Arial", 16));
                titleLabel.setWrapText(true);

                HBox bottomHBox = new HBox(10);
                bottomHBox.setAlignment(Pos.CENTER_LEFT);

                Label timeLabel = new Label(time);
                timeLabel.setFont(Font.font("Arial", 12));
                timeLabel.setTextFill(Color.GRAY);

                Label likesLabel = new Label("Likes: " + likes);
                likesLabel.setFont(Font.font("Arial", 12));
                likesLabel.setTextFill(Color.GRAY);

                Label commentsLabel = new Label("Comments: " + comments);
                commentsLabel.setFont(Font.font("Arial", 12));
                commentsLabel.setTextFill(Color.GRAY);

                bottomHBox.getChildren().addAll(timeLabel, likesLabel, commentsLabel);

                Image image = new Image(getClass().getResourceAsStream(imagePath));
                if (image.isError()) {
                        System.err.println("Error loading image: " + imagePath);
                }
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setFitHeight(40);
                imageView.setPreserveRatio(true);

                HBox newsItemHBox = new HBox(10);
                newsItemHBox.setAlignment(Pos.CENTER_LEFT);
                newsItemHBox.getChildren().addAll(imageView, newsItemVBox);

                newsItemVBox.getChildren().addAll(sourceLabel, titleLabel, bottomHBox);

                parent.getChildren().add(newsItemHBox);
        }
}
