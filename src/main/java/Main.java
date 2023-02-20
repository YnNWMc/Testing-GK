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
    ArrayList<Object2D> objects = new ArrayList<Object2D>();
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
        objectsRect.add(new Rectangle(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\Pert2\\Main\\resources\\shaders/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(0.0f, 0.0f, 0.0f),
                                        new Vector3f(0.5f, 0.0f, 0.0f),
                                        new Vector3f(0.0f, 0.5f, 0.0f),
                                        new Vector3f(0.5f, 0.5f, 0.0f)
                                )
                        ),
                        new Vector4f(1.0f,1.0f,1.0f,1.0f),
                        Arrays.asList(0,1,2,1,2,3)
                )
        );
    }
        public void loop() {
            while (window.isOpen()) {
                window.update();
                glClearColor(0.00f, 0.0f, 0.0f, 0.0f); // RapidTables.com (RGB color code chart)
                GL.createCapabilities();

                for (Object2D object2d : objects) {
                    object2d.drawWithVerticeColor();
                }

                for (Object2D object2d : objectsRect) {
                    object2d.draw();
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

