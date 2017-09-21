/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
/**
 *
 * @author dudnikiljavitalevich
 */
public class Maze extends Application {
    
    final int ScrWidth = 650;
    final int ScrHeight = 650;
   
    int[][] Map1 = {
    {0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},
    {0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,0,1,0,0,1,0},
    {0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,1,0},
    {0,0,0,1,0,1,0,0,1,0,1,1,1,1,0,1,0,1,0,1,0,1,0,0,1,0},
    {0,1,0,1,0,1,1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,1,0,1,0},
    {0,0,0,1,0,1,0,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,0},
    {0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0},
    {0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,0,0,0},
    {1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1},
    {1,0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,0,0,0,0,1,0,0},
    {0,0,0,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,1,0,0},
    {0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,0},
    {0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,1,0},
    {0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1,0},
    {0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,0,0},
    {0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0},
    {0,1,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0},
    {0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0}};
    
    int[][] Map2 = {
    {0,1,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {1,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,1,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,1,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,0,1,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    
    int[][] Map3 = {
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};   
    
    int playerX=0;
    int playerY=0;
    int finishX;
    int finishY;
    int finishX1=16;
    int finishY1=19;
    int finishX2=25;
    int finishY2=0;
    int finishX3=25;
    int finishY3=0;    
    int steps=0;
    int[][] Map;
    int level=0;
    Image img_player,img_wall,img_door,img_ground;
    int state=2;
    int score1=1000;
    int score2=1000;
    int score3=1000;
    

    
    
    
    public Maze() 
    {
    }

    public void menu(GraphicsContext graphicsContext)
    {
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++) 
                if (i==0||j==0||i==25||j==25)
                   graphicsContext.drawImage(img_wall,i*25,j*25);
                else
                   graphicsContext.drawImage(img_ground,i*25,j*25);
        graphicsContext.setFill(Color.SILVER);
        graphicsContext.fillRect(225, 225, ScrWidth-475, ScrHeight-475);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText("Tap SPACE to start New Game ", 235, 255);
        graphicsContext.fillText("Tap ESC to exit", 270, 320);       
                    }
    
    public void score(GraphicsContext graphicsContext)
    {
    graphicsContext.setFill(Color.SILVER);
        graphicsContext.fillRect(0, 0, ScrWidth, ScrHeight);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText("Conratulations! Lvl "+(level+1)+" completed!", 250, 250);
        graphicsContext.fillText("Number of steps = "+steps, 280, 270);
        if (level==0&&score1>steps)   //сверяем уровень и проверяем результат
        {
            score1=steps;   //записываем новый рекорд
        }
        if (level==1&&score2>steps)   //сверяем уровень и проверяем результат
        {
            score2=steps;   //записываем новый рекорд
        }
        if (level==2&&score3>steps)   //сверяем уровень и проверяем результат
        {
            score3=steps;   //записываем новый рекорд
        }        
        graphicsContext.fillText("Tap SPACE to continue", 280, 300);
        graphicsContext.fillText("Tap ESC to continue", 280, 320);
        graphicsContext.fillText("Highscores:", 280, 340);
        graphicsContext.fillText("Level 1 - "+score1, 280, 360);
        graphicsContext.fillText("Level 2 - "+score2, 280, 380);
        graphicsContext.fillText("Level 3 - "+score3, 280, 400);
    }
    
    public void repaint(GraphicsContext graphicsContext)
    {
        if (state==0)
                {
        graphicsContext.setFill(Color.SILVER);
        graphicsContext.fillRect(0, 0, ScrWidth, ScrHeight);
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++)
                if(Map[j][i]!=0)
                    graphicsContext.drawImage(img_wall,i*25,j*25);
                else
                    graphicsContext.drawImage(img_ground,i*25,j*25);
        graphicsContext.drawImage(img_player, playerX*25, playerY*25);
        graphicsContext.drawImage(img_door,finishX*25, finishY*25);

                }
                if (state==1)
            score(graphicsContext);
        if (state==2)
            menu(graphicsContext);
                }
        
    
    public void move(int newX, int newY)
    {
    if (newX>=0&&newY>=0&&newX<=Map.length&&newY<=Map[0].length)
            {
                if (Map[newY][newX]==0)
                {
                    playerX=newX;
                    playerY=newY;
                    steps++;
                    if (playerX==finishX&&playerY==finishY)
                        state=1;    
                }
            }
    }    
        
    @Override
    public void start(Stage primaryStage) 
    {
        Canvas canvas = new Canvas(ScrWidth, ScrHeight);
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root,ScrWidth, ScrHeight);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        img_player = new Image("file:C:\\Users\\Илья\\Documents\\NetBeansProjects\\JavaApplication1\\src\\maze\\plr.png");
        img_wall = new Image("file:C:\\Users\\Илья\\Documents\\NetBeansProjects\\JavaApplication1\\src\\maze\\wall.png");
        img_door = new Image("file:C:\\Users\\Илья\\Documents\\NetBeansProjects\\JavaApplication1\\src\\maze\\door.png");
        img_ground = new Image("file:C:\\Users\\Илья\\Documents\\NetBeansProjects\\JavaApplication1\\src\\maze\\ground.jpg");
        Map=Map1;
        finishX=finishX1;
        finishY=finishY1;
        playerX=0;
        playerY=0;
        
        repaint(graphicsContext);

        
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>
  () {

        @Override
        public void handle(KeyEvent t)
        {   //обрабатываем нажатие кнопок
          if(t.getCode()==KeyCode.SPACE)
          {
           if (state==2)
           {
               state=0;
           repaint(graphicsContext);
           }
           if (state==1)
           {
           state=0;           
                   switch (level)
                   {
                       case 0:level=1;
                         {
                           Map=Map2;                          
                         }   
                           finishX=finishX2;
                           finishY=finishY2;
                           playerX=0;
                           playerY=0;
                           repaint(graphicsContext);
                           break;
                         case 1:level=2;
                         {
                           Map=Map3;   
                         }
                           finishX=finishX3;
                           finishY=finishY3;
                           playerX=0;
                           playerY=0;
                           repaint(graphicsContext);
                           break;   
                       case 2:level=0;
                       {
                           Map=Map1;
                       }
                           finishX=finishX3;
                           finishY=finishY3;
                           playerX=0;
                           playerY=0;
                           repaint(graphicsContext);
                           break;  
                   }
              steps=0;     
           } 
          }  
          if(t.getCode()==KeyCode.ESCAPE)
          {
           primaryStage.close();
          }
          if(t.getCode()==KeyCode.LEFT)
          {
           move(playerX-1,playerY);
           repaint(graphicsContext);
          }
          if(t.getCode()==KeyCode.RIGHT)
          {
           move(playerX+1,playerY);   
           repaint(graphicsContext);
          }
          if(t.getCode()==KeyCode.UP)
          {
           move(playerX,playerY-1);   
           repaint(graphicsContext);
          }
          if(t.getCode()==KeyCode.DOWN)
          {
           move(playerX,playerY+1);   
           repaint(graphicsContext);
          }
        }
    });
        
        primaryStage.setTitle("Відтворення оптимального руху об’єкта на площині з використанням мови Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
