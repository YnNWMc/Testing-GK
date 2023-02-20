import Engine.Object2D;
import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window(800, 800, "Hello World");
    ArrayList<Object2D> objectsTri = new ArrayList<Object2D>();
    ArrayList<Object2D> objectsRect = new ArrayList<Object2D>();

    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        // code dst jangan ditaruh diatas code diatas
        //

        // Langit
        objectsRect.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,1.0f,0.0f),
                                new Vector3f(-1.0f,1.0f,0.0f),
                                new Vector3f(-1.0f,-1.0f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f)

                        )
                ), new Vector4f(0.0f,0.0f,1.0f,0.0f),
                Arrays.asList(0,1,2,0,2,3)

        ));

        // RUmput
        objectsRect.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(1.0f,-0.5f,0.0f),
                                        new Vector3f(-1.0f,-0.5f,0.0f),
                                        new Vector3f(-1.0f,-1.0f,0.0f),
                                        new Vector3f(1.0f,-1.0f,0.0f)
                                )
                        ),
                        new Vector4f(0.0f,1.0f,0.0f,0.0f),
                    Arrays.asList(0,1,2,0,2,3)
                )
        );

        //BOdy rumah
        objectsRect.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.65f,0.0f,0.0f), // Top right
                                new Vector3f(-0.65f,0.0f,0.0f),// Top Left
                                new Vector3f(-0.65f,-0.6f,0.0f), // Bot left
                                new Vector3f(0.65f,-0.6f,0.0f) //Bot Right

                        )
                ), new Vector4f(1.0f,0.5f,0.0f,1.0f),
                Arrays.asList(0,1,2,0,2,3)
        ));
        // Atap
        objectsRect.add(new Rectangle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.6f,0.2f,0.0f),//Top Right
                                new Vector3f(-0.6f,0.2f,0.0f),//Top Left
                                new Vector3f(-0.7f,-0.2f,0.0f),//Bot Left
                                new Vector3f(0.7f,-0.2f,0.0f)// Bot Right

                        )
                ), new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,0,2,3)
        ));
        // Inner Atap
        objectsRect.add(new Rectangle(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.55f,0.15f,0.0f),//Top Right
                                new Vector3f(-0.55f,0.15f,0.0f),//Top Left
                                new Vector3f(-0.65f,-0.2f,0.0f),//Bot Left
                                new Vector3f(-0.425f,-0.2f,0.0f)// Bot Right
                        )
                )
                , new Vector4f(1.0f,0.5f,0.0f,1.0f),
                Arrays.asList(0,3,2)
        ));
    }
        public void loop() {
            while (window.isOpen()) {
                window.update();
                    glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
                GL.createCapabilities();



                for (Object2D object2dR : objectsRect) {
                    object2dR.draw();
                }
                for (Object2D object2dT : objectsTri) {
                    object2dT.draw();
                }
                //Restore State
                glDisableVertexAttribArray(0);
                // Pull for window events
                // The key callback above will only be
                // invoked during this call
                glfwPollEvents();
            }
        }

        public static void main (String[]args){
            new Main().run();
        }
    }

/* warna 1 color segitiga
        objects.add(new Object2D(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(0.0f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f)
                                )
                        ),
                        new Vector4f ....
                )
                )
        ));
        }
         */

        /* Dengan color per vertice segitiga
        objects.add(new Object2D(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(0.0f, 0.5f, 0.0f),
                                        new Vector3f(-0.5f, -0.5f, 0.0f),
                                        new Vector3f(0.5f, -0.5f, 0.0f)
                                )
                        ),
                        new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,0.0f,0.0f),
                                new Vector3f(0.0f,1.0f,0.0f),
                                new Vector3f(0.0f,0.0f,1.0f)
                )
                )
        )
        );

         */