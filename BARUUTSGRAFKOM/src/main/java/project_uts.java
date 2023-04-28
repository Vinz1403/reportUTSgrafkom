import Engine.*;
import Engine.Object;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL20.*;
//import static glfwGetTime;

public class project_uts {
    private Window window = new Window(800,800,"Hello World");
    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Object> bomber = new ArrayList<>();

    ArrayList<Object> objectsBox = new ArrayList<>();
    ArrayList<Object> objectsMush = new ArrayList<>();

    private float red = 0.0f;
    private float green = 0.0f;
    private float blue = 0.0f;
    ArrayList<Object> objectsLine = new ArrayList<>();

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    private boolean anima1 = true;
    private int count;
    int size = 0;
    boolean checks = true;

    public void run(){

        init();
        loop();

        glfwSetErrorCallback(null).free();
    }

//cek garis
    public boolean LeftButtonPressed = false;
    public boolean change = false;
    public int check;


    public void babayaga(){
        //boo       #0
        objects.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));


        objects.get(0).scaleObject(0.5f,0.5f,0.5f);
//        child
//        matakiri #0#0
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objects.get(0).getChildObject().get(0).scaleObject(0.04f,0.08f,0.03f);
        objects.get(0).getChildObject().get(0).translateObject(0.08f, 0.05f, 0.23f);
        Vector3f mataKiri = new Vector3f(objects.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(0).translateObject(-mataKiri.x, -mataKiri.y, -mataKiri.z);
        objects.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-30f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(0).setAngleX(-30f);
        objects.get(0).getChildObject().get(0).translateObject(mataKiri.x,mataKiri.y, mataKiri.z);
//        end matakiri
//        mata kanan #0#1
        objects.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objects.get(0).getChildObject().get(1).scaleObject(0.04f,0.08f,0.03f);
        objects.get(0).getChildObject().get(1).translateObject(-0.08f, 0.05f, 0.23f);
        Vector3f mataKanan = new Vector3f(objects.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(1).translateObject(-mataKanan.x, -mataKanan.y, -mataKanan.z);
        objects.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(-30f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(1).setAngleX(-30f);
        objects.get(0).getChildObject().get(1).translateObject(mataKanan.x,mataKanan.y, mataKanan.z);
//end mata kanan


//        alis mata kanan #0#0#01
        objects.get(0).getChildObject().get(0).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));
        objects.get(0).getChildObject().get(0).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));


        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.12f, 0.12f, 0.185f));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.08f, 0.09f, 0.22f));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).add_vertices(new Vector3f(-0.05f, 0.12f, 0.218f));

        curveLine(objects.get(0).getChildObject().get(0).getChildObject().get(0), objects.get(0).getChildObject().get(0).getChildObject().get(1));
        objects.get(0).getChildObject().get(0).getChildObject().get(0).get_vertices().clear();
//        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, -0.012f, 0.218f);
        Vector3f aliskanan = new Vector3f(objects.get(0).getChildObject().get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-aliskanan.x, -aliskanan.y, -aliskanan.z);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(-16f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(aliskanan.x,aliskanan.y, aliskanan.z);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, -0.017f, 0.245f);
        objects.get(0).getChildObject().get(0).getChildObject().get(1).setAngleY(-16f);

//        end alis mata kanan
//        -----
//        alis mata kiri #0#0#23
        objects.get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));
        objects.get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));


        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.05f, 0.12f, 0.218f));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.08f, 0.09f, 0.22f));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.12f, 0.12f, 0.185f));

        curveLine(objects.get(0).getChildObject().get(1).getChildObject().get(0), objects.get(0).getChildObject().get(1).getChildObject().get(1));
        objects.get(0).getChildObject().get(1).getChildObject().get(0).get_vertices().clear();
        Vector3f aliskiri = new Vector3f(objects.get(0).getChildObject().get(1).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(-aliskiri.x, -aliskiri.y, -aliskiri.z);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(16f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(aliskiri.x,aliskiri.y, aliskiri.z);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.0f, -0.017f, 0.245f);
        objects.get(0).getChildObject().get(1).getChildObject().get(1).setAngleY(16f);

//        end alis mata kiri

        //mulut #0#2
        objects.get(0).getChildObject().add(new QuarterSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(0.898f, 0.223f, 0.207f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.03f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).scaleObject(0.38f, 0.16f, 0.3f);
        objects.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, 0.18f);
        Vector3f mulut = new Vector3f(objects.get(0).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).translateObject(-mulut.x, -mulut.y, -mulut.z);
        objects.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(-90f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(100f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).translateObject(mulut.x,mulut.y, mulut.z);
        objects.get(0).getChildObject().get(2).setAngleY(-90f);
        objects.get(0).getChildObject().get(2).setAngleX(100f);

//        gigi1 #0#2#0
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.1f, -0.05f, 0.23f);
        Vector3f gigi1 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-gigi1.x, -gigi1.y, -gigi1.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(-28f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(15f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(gigi1.x,gigi1.y, gigi1.z);
//        objects.get(0).getChildObject().get(2).getChildObject().get(0).setAngleY(-28f);
//        objects.get(0).getChildObject().get(2).getChildObject().get(0).setAngleY(15f);
//        end gigi1
        //        gigi2 #0#2#1
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-0.035f, -0.055f, 0.25f);
        Vector3f gigi2 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-gigi2.x, -gigi2.y, -gigi2.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(-10f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(10f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(gigi2.x,gigi2.y, gigi2.z);
//        objects.get(0).getChildObject().get(2).getChildObject().get(1).setAngleY(-10f);
//        objects.get(0).getChildObject().get(2).getChildObject().get(1).setAngleX(10f);
//        end gigi2
        //        gigi3 #0#2#2
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(0.035f, -0.055f, 0.25f);
        Vector3f gigi3 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(-gigi3.x, -gigi3.y, -gigi3.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(10f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(10f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(gigi3.x,gigi3.y, gigi3.z);
//        end gigi3
        //        gigi4 #0#2#3
        objects.get(0).getChildObject().get(2).getChildObject().add(new TriangleC(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f),
                30.0f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(3).scaleObject(0.8f, 1.0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(0.1f, -0.05f, 0.23f);
        Vector3f gigi4 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(-gigi4.x, -gigi4.y, -gigi4.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(28f),-0.0f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(15f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(gigi4.x,gigi4.y, gigi4.z);
//        end gigi4

        //        lidah main  #0#2#4
        objects.get(0).getChildObject().get(2).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.1f, 0.1f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).scaleObject(1.0f, 0.5f, 1.8f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(0.0f, -0.1f, 0.2f);
        Vector3f lidah0 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(-lidah0.x, -lidah0.y, -lidah0.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).rotateObject((float)Math.toRadians(65f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(lidah0.x,lidah0.y, lidah0.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).setAngleX(65f);
//        end lidah 0
        //        lidah c1  #0#2#4#0
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.05f, 0.05f, 0.05f)
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).scaleObject(0.8f, 0.3f, 1.8f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(0.0f, -0.14f, 0.225f);
        Vector3f lidah1 = new Vector3f(objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(-lidah1.x, -lidah1.y, -lidah1.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(80f),1.0f, -0.0f, 0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).translateObject(lidah1.x,lidah1.y, lidah1.z);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).getChildObject().get(0).setAngleX(80f);
//        end lidah 0

//        end mulut

//        main tail #0#3
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).scaleObject(1.8f,0.8f,1.5f);
        objects.get(0).getChildObject().get(3).translateObject(0.0f, -0.15f, -0.115f);
        Vector3f tail0 = new Vector3f(objects.get(0).getChildObject().get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).translateObject(-tail0.x, -tail0.y, -tail0.z);
        objects.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(-150f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).translateObject(tail0.x,tail0.y, tail0.z);
        objects.get(0).getChildObject().get(3).setAngleX(-150);
//        child tail 1 #0#3#0
        objects.get(0).getChildObject().get(3).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(1.8f,0.8f,1.5f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.0f, -0.136f, -0.18f);
        Vector3f tail2 = new Vector3f(objects.get(0).getChildObject().get(3).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-tail2.x, -tail2.y, -tail2.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(-130f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tail2.x,tail2.y, tail2.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(0).setAngleX(-130);
//        child tail 1 #0#3#1
        objects.get(0).getChildObject().get(3).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(1.5f,0.6f,1.5f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(0.0f, -0.115f, -0.23f);
        Vector3f tail3 = new Vector3f(objects.get(0).getChildObject().get(3).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(-tail3.x, -tail3.y, -tail3.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(-120f),0.5f, 0.0f, 0.0f);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(tail3.x,tail3.y, tail3.z);
        objects.get(0).getChildObject().get(3).getChildObject().get(1).setAngleX(-120);
//        end tail

        //        main right hand #0#4
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).scaleObject(0.4f,0.4f,0.6f);
        objects.get(0).getChildObject().get(4).translateObject(-0.2f, -0.0f, 0.1f);
        Vector3f rh0 = new Vector3f(objects.get(0).getChildObject().get(4).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).translateObject(-rh0.x, -rh0.y, -rh0.z);
        objects.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(-65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(-15f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(4).translateObject(rh0.x,rh0.y, rh0.z);
        objects.get(0).getChildObject().get(4).setAngleY(-65);
        objects.get(0).getChildObject().get(4).setAngleZ(-15);
////        child right hand 1 #0#4#0
        objects.get(0).getChildObject().get(4).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.32f,0.32f,0.6f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.223f, 0.005f, 0.109f);
        Vector3f rh1 = new Vector3f(objects.get(0).getChildObject().get(4).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-rh1.x, -rh1.y, -rh1.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-25f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(rh1.x,rh1.y, rh1.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).setAngleY(-65);
        objects.get(0).getChildObject().get(4).getChildObject().get(0).setAngleZ(-25);
//        child right hand 1 #0#4#1
        objects.get(0).getChildObject().get(4).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.28f,0.28f,0.8f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-0.233f, 0.01f, 0.109f);
        Vector3f rh2 = new Vector3f(objects.get(0).getChildObject().get(4).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(-rh2.x, -rh2.y, -rh2.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(-65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(-30f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(rh2.x,rh2.y, rh2.z);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).setAngleY(-65);
        objects.get(0).getChildObject().get(4).getChildObject().get(1).setAngleZ(-30);
//        end right hand

        //        main left hand #0#5
        objects.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).scaleObject(0.4f,0.4f,0.6f);
        objects.get(0).getChildObject().get(5).translateObject(0.2f, -0.0f, 0.1f);
        Vector3f lh0 = new Vector3f(objects.get(0).getChildObject().get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).translateObject(-lh0.x, -lh0.y, -lh0.z);
        objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(15f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).translateObject(lh0.x,lh0.y, lh0.z);
        objects.get(0).getChildObject().get(5).setAngleY(65);
        objects.get(0).getChildObject().get(5).setAngleZ(15);
//        child left hand 1 #0#5#0
        objects.get(0).getChildObject().get(5).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.32f,0.32f,0.6f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.223f, 0.005f, 0.109f);
        Vector3f lh1 = new Vector3f(objects.get(0).getChildObject().get(5).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-lh1.x, -lh1.y, -lh1.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(25f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(lh1.x,lh1.y, lh1.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).setAngleY(65);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).setAngleZ(25);
//        child left hand 1 #0#5#1
        objects.get(0).getChildObject().get(5).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.95f, 0.95f, 0.97f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objects.get(0).getChildObject().get(5).getChildObject().get(1).scaleObject(0.28f,0.28f,0.8f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(0.233f, 0.01f, 0.109f);
        Vector3f lh2 = new Vector3f(objects.get(0).getChildObject().get(5).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(-lh2.x, -lh2.y, -lh2.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(65f),0.f, 1.0f, 0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float)Math.toRadians(30f),0.0f, 0.0f, 1.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(lh2.x,lh2.y, lh2.z);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).setAngleY(65);
        objects.get(0).getChildObject().get(5).getChildObject().get(1).setAngleZ(30);
//        end left hand

        objects.get(0).translateObject(0.8f,0f,0f);
//end babayaga
    }
    public void bomb(){
        //bomber
        bomber.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));


        bomber.get(0).scaleObject(0.5f,0.5f,0.5f);
////        child
//        matakanan #0#0
        bomber.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.6f, 0.6f, 0.6f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        bomber.get(0).getChildObject().get(0).scaleObject(0.04f,0.08f,0.03f);
        bomber.get(0).getChildObject().get(0).translateObject(0.08f, 0.05f, 0.23f);
        Vector3f mataKanan = new Vector3f(bomber.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        bomber.get(0).getChildObject().get(0).translateObject(-mataKanan.x, -mataKanan.y, -mataKanan.z);
        bomber.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-30f),0.5f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).translateObject(mataKanan.x,mataKanan.y, mataKanan.z);
        bomber.get(0).getChildObject().get(0).setAngleX(-30);
////        end matakiri
//        mata kiri bomber #0#1
        bomber.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.6f, 0.6f, 0.6f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)

        ));

        bomber.get(0).getChildObject().get(1).scaleObject(0.04f,0.08f,0.03f);
        bomber.get(0).getChildObject().get(1).translateObject(-0.08f, 0.05f, 0.23f);
        Vector3f mataKiri = new Vector3f(bomber.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        bomber.get(0).getChildObject().get(1).translateObject(-mataKiri.x, -mataKiri.y, -mataKiri.z);
        bomber.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(-30f),0.5f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(1).translateObject(mataKiri.x,mataKiri.y, mataKiri.z);
        bomber.get(0).getChildObject().get(1).setAngleX(-30);

        bomber.get(0).getChildObject().get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.7529f, 0.7529f, 0.7529f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f),
                0.05f
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(1.0f, 1.0f, 1.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.22f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(0).setAngleX(90);




        //clinder atas buat korek api
        bomber.get(0).getChildObject().get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.025f, 0.025f, 0.025f),
                0.125f
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(1.0f, 1.0f, 1.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.0f, 0.22f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).setAngleX(90);

        //kaki kiri
        bomber.get(0).getChildObject().get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.025f, 0.025f, 0.025f),
                0.05f
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(1.0f, 1.0f, 1.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.1f, -0.27f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).setAngleX(-90);

        // sepatu kiri

        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.08f, 0.08f, 0.08f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.08f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.1f, -0.36f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).setAngleX(-90);


        //bagian2 sepatu kiri
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(1).scaleObject(0.08f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-0.1f, -0.36f, 0.075f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(1).setAngleX(-90);



        //kaki kanan
        bomber.get(0).getChildObject().get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.025f, 0.025f, 0.025f),
                0.05f
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(1.0f, 1.0f, 1.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(0.1f, -0.27f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).setAngleY(-90);

        // sepatu kanan

        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.08f, 0.08f, 0.08f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.08f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.1f, -0.36f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).setAngleY(-90);



        //bagian2 bagian kanan
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new halfSphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(0.08f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).rotateObject((float)Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).translateObject(0.1f, -0.36f, 0.075f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).setAngleX(-90);


        //bagian ekor
        bomber.get(0).getChildObject().get(0).getChildObject().add(new Cylinder(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.025f, 0.025f, 0.025f), 0.025f
        ));
//
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(1.0f, 1.0f, 1.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(0.0f), 1.0f, 0.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(0.0f, 0.0f, -0.27f);


        //ekor atas
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().add(new Pipe(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.8f, 0.6f, 0.3f, 1.0f),
                new Vector3f(0.0f,0.0f,0.0f),
                new Vector3f(0.5f,0.5f,0.5f),0.1f,0.3f,360

        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(90.0f), 0.0f, 1.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.0f, 0.065f, -0.3f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).setAngleY(90);

        //ekor bawah
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().add(new Pipe(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.8f, 0.6f, 0.3f, 1.0f),
                new Vector3f(0.0f,0.0f,0.0f),
                new Vector3f(0.5f,0.5f,0.5f),0.1f,0.3f,360

        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float)Math.toRadians(90.0f), 0.0f, 1.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.0f, -0.065f, -0.3f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(1).setAngleY(90);


        //ekor bagian setengah lingkaran
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(0.855f, 0.647f, 0.125f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.068f, 0.068f, 0.068f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(2).scaleObject(0.4f, 0.4f, 0.4f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float)Math.toRadians(180.0f), 0.0f, 1.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(2).translateObject(0.0f, 0.0f, -0.291f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(2).setAngleY(180);


        //COB BEZIER PERTAMA
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(3.0f,0.0f,0.0f,0.0f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(3.0f,0.0f,0.0f,0.0f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.03f, 0.52f, 0.485f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.0f, 0.29f, 0.0f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(-0.03f, 0.52f, 0.518f));

        curveLine(bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0), bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).get_vertices().clear();
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0f,-0.06f,0f);







        //BEZIER 2
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(0.0f,0.0f,0.0f,1.0f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.03f, 0.52f, 0.485f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.0f, 0.29f, 0.0f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(-0.03f, 0.52f, 0.518f));

        curveLine(bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0), bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).get_vertices().clear();

        Vector3f bezier2 = new Vector3f(bomber.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(-bezier2.x, -bezier2.y, -bezier2.z);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float)Math.toRadians(60),0.0f, 1.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(bezier2.x + 0.115f,bezier2.y - 0.06f, bezier2.z + 0.05f);



        //BEZIER 3 BOMBER

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Bezier(
                Arrays.asList(new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(),
                new Vector4f(1.8f,0.3f,0.0f,1.0f)
        ));

        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.03f, 0.52f, 0.485f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(0.0f, 0.29f, 0.0f));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).add_vertices(new Vector3f(-0.03f, 0.52f, 0.518f));

        curveLine(bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0), bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(3));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).get_vertices().clear();

        Vector3f bezier3 = new Vector3f(bomber.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(3).translateObject(-bezier3.x, -bezier3.y, -bezier3.z);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(3).rotateObject((float)Math.toRadians(90),0.0f, 1.0f, 0.0f);
        bomber.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(3).translateObject(bezier3.x - 0.025f,bezier3.y - 0.06f, bezier3.z - 0.18f);

        bomber.get(0).translateObject(2f,0f,0f);

    }
    public void boxNmush(){
        //kotak
        objectsBox.add(new cube(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 1.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.6f, 0.6f, 0.6f)
        ));
// muka
        objectsMush.add(new SphereJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(1.0f, 0.992f, 0.816f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objectsBox.get(0).scaleObject(0.5f, 0.5f, 0.5f);
        objectsMush.get(0).scaleObject(0.13f, 0.15f, 0.13f);
        objectsMush.get(0).translateObject(0.0f, -0.02f, 0f);

//      mata kiri
        objectsMush.get(0).getChildObject().add(new SphereJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objectsMush.get(0).getChildObject().get(0).scaleObject(0.02f,0.04f,0.015f);
        objectsMush.get(0).getChildObject().get(0).translateObject(0.02f, -0.02f, 0.06f);
        Vector3f mataKiri = new Vector3f(objectsMush.get(0).getChildObject().get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objectsMush.get(0).getChildObject().get(0).translateObject(-mataKiri.x, -mataKiri.y, -mataKiri.z);
        objectsMush.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(15f),-0.5f, 0.0f, 0.0f);
        objectsMush.get(0).getChildObject().get(0).translateObject(mataKiri.x,mataKiri.y, mataKiri.z);
//        end matakiri
//        mata kanan #0#1
        objectsMush.get(0).getChildObject().add(new SphereJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objectsMush.get(0).getChildObject().get(1).scaleObject(0.02f,0.04f,0.015f);
        objectsMush.get(0).getChildObject().get(1).translateObject(-0.02f, -0.02f, 0.06f);
        Vector3f mataKanan = new Vector3f(objectsMush.get(0).getChildObject().get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        objectsMush.get(0).getChildObject().get(1).translateObject(-mataKanan.x, -mataKanan.y, -mataKanan.z);
        objectsMush.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(15f),-0.5f, 0.0f, 0.0f);
        objectsMush.get(0).getChildObject().get(1).translateObject(mataKanan.x,mataKanan.y, mataKanan.z);

//head
        objectsMush.get(0).getChildObject().add(new completeEP(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(1.0f, 0.012f, 0.243f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));
        objectsMush.get(0).getChildObject().add(new ElipticParaboloid(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
//                color
                new Vector4f(0.0f, 1.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.1f, 0.1f, 0.1f)
        ));

        objectsMush.get(0).getChildObject().get(2).scaleObject(1.1f, 1.1f, 1.1f);
        objectsMush.get(0).getChildObject().get(2).translateObject(0.0f, 0.2f, 0.0f);
        objectsMush.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        objectsMush.get(0).getChildObject().get(2).translateObject(0.0f, 0.03f, 0.2f);

        objectsMush.get(0).getChildObject().get(3).scaleObject(1.1f, 1.1f, 1.1f);
        objectsMush.get(0).getChildObject().get(3).translateObject(0.0f, 0.2f, 0.0f);
        objectsMush.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        objectsMush.get(0).getChildObject().get(3).translateObject(0.0f, 0.05f, -0.2f);


//
//garis
        objectsLine.add(new cube(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f)
        ));

        objectsLine.get(0).scaleObject(0.6f, 0.6f, 0.6f);

        objectsLine.get(0).getChildObject().add(new cube(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of(
                )
        ),
//                color
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f)
        ));

        objectsLine.get(0).getChildObject().get(0).scaleObject(0.6f, 0.6f, 0.6f);
        objectsLine.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-180.0f), 1.0f, 0.0f, 0.0f);


//baut
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));
        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));

        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));

        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));

        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));

        objectsBox.get(0).getChildObject().add(new CylinderJu(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ), new ArrayList<>(
                List.of()
        ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                center
                new Vector3f(0.0f, 0.0f, 0.0f),
//                rad
                new Vector3f(0.5f, 0.5f, 0.5f),
                0.5f, 1.0f, 360
        ));


        objectsBox.get(0).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(3).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(4).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(5).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(6).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(7).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(8).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(9).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(10).scaleObject(0.04f, 0.04f, 0.33f);
        objectsBox.get(0).getChildObject().get(11).scaleObject(0.04f, 0.04f, 0.33f);

        objectsBox.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 1.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 1.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 1.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-90.0f), 0.0f, 1.0f, 0.0f);

        objectsBox.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(9).rotateObject((float) Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);
        objectsBox.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-90.0f), 1.0f, 0.0f, 0.0f);


        objectsBox.get(0).getChildObject().get(0).translateObject(0.12f, 0.12f, 0.0f);
        objectsBox.get(0).getChildObject().get(1).translateObject(-0.12f, 0.12f, 0.0f);
        objectsBox.get(0).getChildObject().get(2).translateObject(-0.12f, -0.12f, 0.0f);
        objectsBox.get(0).getChildObject().get(3).translateObject(0.12f, -0.12f, 0.0f);

        objectsBox.get(0).getChildObject().get(4).translateObject(0.0f, 0.12f, 0.12f);
        objectsBox.get(0).getChildObject().get(5).translateObject(0.0f, 0.12f, -0.12f);
        objectsBox.get(0).getChildObject().get(6).translateObject(0.0f, -0.12f, -0.12f);
        objectsBox.get(0).getChildObject().get(7).translateObject(0.0f, -0.12f, 0.12f);

        objectsBox.get(0).getChildObject().get(8).translateObject(0.12f, 0.0f, 0.12f);
        objectsBox.get(0).getChildObject().get(9).translateObject(0.12f, 0.0f, -0.12f);
        objectsBox.get(0).getChildObject().get(10).translateObject(-0.12f, 0.0f, -0.12f);
        objectsBox.get(0).getChildObject().get(11).translateObject(-0.12f, 0.0f, 0.12f);

    }
    public void init(){
        window.init();
        GL.createCapabilities();
//        kamera
        camera.setPosition(-0.5f,0.0f, 3.0f);
        camera.setRotation((float) Math.toRadians(0.0f),(float) Math.toRadians(30.0f));
        babayaga();
        bomb();
        boxNmush();
    }

//masukin class bezier
//  func to curve
    public void curveLine(Object object2d, Object newObjects){
        float x,y;
        newObjects.get_vertices().clear();
        int n = object2d.getVerticesSize() -1;
        for (float t = 0; t <= 1; t += 0.01){
            x = 0;
            y = 0;
            int count = object2d.getVerticesSize() - 1;

            for (int i = 0; i < object2d.getVerticesSize(); i++){
                Vector3f pos = object2d.getPos(i);
                float incr = (float) (Math.pow((1 - t), count) * Math.pow(t, i)) * C(n,i);
                x += (incr * pos.x);
                y += (incr * pos.y);
                count--;
            }
            newObjects.add_vertices(new Vector3f(x,y, 0.0f));
        }
    }
//    endcurveline

    public int C(int n, int r){
        return fak(n) / (fak(n-r)*fak(r));
    }

    public int fak( int angka){
        if (angka == 0 || angka == 1){
            return 1;
        }else {
            return angka * fak(angka-1);
        }
    }
//    end func to curve
//    end masukin class bezier
float rotate = 0.5f;
/////////////////////////////BOMBERRR JALANNNNNNNNNN START
    public void bomberWalk (){
//       left leg
        Object leftLeg = bomber.get(0).getChildObject().get(0).getChildObject().get(2);
        Vector3f ll = new Vector3f(leftLeg.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        System.out.println("before angle: "+leftLeg.getAngleX());
        if(leftLeg.getAngleX()>=360 || leftLeg.getAngleX()<=-90) leftLeg.setAngleX(0);
        if(leftLeg.getAngleX() >=  9 && leftLeg.getAngleX() <= 10){
            rotate = -0.5f;
            System.out.println("add neg "+leftLeg.getAngleX());
        }else if(leftLeg.getAngleX() <= -10 && leftLeg.getAngleX() <= -9 ){
            rotate = 0.5f;
            System.out.println("add pos "+leftLeg.getAngleX());
        }

        leftLeg.translateObject(-ll.x,-ll.y,-ll.z);
        leftLeg.rotateObject((float)Math.toRadians(rotate),1.0f,0.0f,0.0f);
        leftLeg.translateObject(ll.x,ll.y,ll.z);
        leftLeg.setAngleX(leftLeg.getAngleX()+rotate);
        System.out.println("after angle: "+leftLeg.getAngleX());


        //right leg
        Object rightLeg = bomber.get(0).getChildObject().get(0).getChildObject().get(3);
        Vector3f rl = new Vector3f(rightLeg.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        System.out.println("before angle: "+rightLeg.getAngleX());
        if(rightLeg.getAngleX()>=360 || rightLeg.getAngleX()<=-90) rightLeg.setAngleX(0);
        if(rightLeg.getAngleX() >=  9 && rightLeg.getAngleX() <= 10){
            rotate = -0.5f;
            System.out.println("add neg "+rightLeg.getAngleX());
        }else if(rightLeg.getAngleX() <= -10 && rightLeg.getAngleX() <= -9 ){
            rotate = 0.5f;
            System.out.println("add pos "+rightLeg.getAngleX());
        }

        rightLeg.translateObject(-rl.x,-rl.y,-rl.z);
        rightLeg.rotateObject((float)Math.toRadians(rotate),-1.0f,0.0f,0.0f);
        rightLeg.translateObject(rl.x,rl.y,rl.z);
        rightLeg.setAngleX(rightLeg.getAngleX()+rotate);
        System.out.println("after angle: "+rightLeg.getAngleX());
    }
//// BOMBER JALANNNNN AKHIRRR

//==================================================================================================================

/// BOMBER EKORRRRRR STARTT

    public void bomberTail (){


        Object tail = bomber.get(0).getChildObject().get(0).getChildObject().get(4);
        Vector3f tl = new Vector3f(tail.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        tail.translateObject(-tl.x,-tl.y,-tl.z);
        tail.rotateObject((float)Math.toRadians(rotate),1.0f,0.0f,0.0f);
        tail.translateObject(tl.x,tl.y,tl.z);
        tail.setAngleX(tail.getAngleX()+rotate);

    }
/// BOMBERR EKORRR AKHIRR

//================================================================================================================

    public void waveRightHand (){
//        rotate = 0.5f;
        Object rightHand = objects.get(0).getChildObject().get(4);
        Vector3f rh = new Vector3f(rightHand.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        System.out.println("before angle: "+rightHand.getAngleX());
        if(rightHand.getAngleX()>=360 || rightHand.getAngleX()<=-360) rightHand.setAngleX(0);
        if(rightHand.getAngleX() >= 59 && rightHand.getAngleX() <= 60){
            rotate = -0.5f;
            System.out.println("add pos "+rightHand.getAngleX());
        }else if(rightHand.getAngleX() >= -10 && rightHand.getAngleX() <= -9){
            rotate = 0.5f;
            System.out.println("add neg "+rightHand.getAngleX());
        }

        rightHand.translateObject(-rh.x,-rh.y,-rh.z);
        rightHand.rotateObject((float)Math.toRadians(rotate),1.0f,0.0f,0.0f);
        rightHand.translateObject(rh.x,rh.y,rh.z);
        rightHand.setAngleX(rightHand.getAngleX()+rotate);
        System.out.println("after angle: "+rightHand.getAngleX());
    }
    public void waveLeftHand (){
//        rotate = 0.5f;
        Object leftHand = objects.get(0).getChildObject().get(5);
        Vector3f rh = new Vector3f(leftHand.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        System.out.println("before angle: "+leftHand.getAngleX());
        if(leftHand.getAngleX()>=360 || leftHand.getAngleX()<=-360) leftHand.setAngleX(0);
        if(leftHand.getAngleX() >= 59 && leftHand.getAngleX() <= 60){
            rotate = -0.5f;
            System.out.println("add pos "+leftHand.getAngleX());
        }else if(leftHand.getAngleX() >= -10 && leftHand.getAngleX() <= -9){
            rotate = 0.5f;
            System.out.println("add neg "+leftHand.getAngleX());
        }

        leftHand.translateObject(-rh.x,-rh.y,-rh.z);
        leftHand.rotateObject((float)Math.toRadians(rotate),1.0f,0.0f,0.0f);
        leftHand.translateObject(rh.x,rh.y,rh.z);
        leftHand.setAngleX(leftHand.getAngleX()+rotate);
        System.out.println("after angle: "+leftHand.getAngleX());
    }

    public void waveTail (){
//        rotate = 0.5f;
        Object tail = objects.get(0).getChildObject().get(3);
        Vector3f rh = new Vector3f(tail.model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
        System.out.println("before angle: "+tail.getAngleY());
        if(tail.getAngleY()>=360 || tail.getAngleY()<=-360) tail.setAngleX(0);
        if(tail.getAngleY() >= 5 && tail.getAngleY() <= 4){
            rotate = -0.5f;
            System.out.println("add pos "+tail.getAngleX());
        }else if(tail.getAngleY() >= -5 && tail.getAngleY() <= -4){
            rotate = 0.5f;
            System.out.println("add neg "+tail.getAngleY());
        }

        tail.translateObject(-rh.x,-rh.y,-rh.z);
        tail.rotateObject((float)Math.toRadians(rotate),0.0f,1.0f,0.0f);
        tail.translateObject(rh.x,rh.y,rh.z);
        tail.setAngleX(tail.getAngleY()+rotate);
        System.out.println("after angle: "+tail.getAngleY());
    }

    public void input(){


//        ROTATING OBJECT
        if(window.isKeyPressed(GLFW_KEY_D)){
//            Y_RIGHT
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,1.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
            objects.get(0).setAngleY(objects.get(0).getAngleY()+1.5f);

        }
        if(window.isKeyPressed(GLFW_KEY_A)){
//            Y_LEFT
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,-1.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
            objects.get(0).setAngleY(objects.get(0).getAngleY()-1.5f);
        }
        if(window.isKeyPressed(GLFW_KEY_S)){
//            X_UP
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),1.0f,0.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);

            objects.get(0).setAngleX(objects.get(0).getAngleX()+1.5f);
        }
        if(window.isKeyPressed(GLFW_KEY_W)){
//            X_DOWN
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),-1.0f,0.0f,0.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);

            objects.get(0).setAngleX(objects.get(0).getAngleX()-1.5f);
        }
        if(window.isKeyPressed(GLFW_KEY_Z)){
//            Z_POS
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,1.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
            objects.get(0).setAngleZ(objects.get(0).getAngleZ()+1.5f);
        }
        if(window.isKeyPressed(GLFW_KEY_X)){
//            Z_NEG
            Vector3f mainbody = new Vector3f(objects.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            objects.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            objects.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,-1.0f);
            objects.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
            objects.get(0).setAngleZ(objects.get(0).getAngleZ()-1.5f);
        }
//      END ROTATING OBJECT

//        ANIMATION
//        LAUGH
//        FADE
        if(window.isKeyPressed(GLFW_KEY_P)){if(objects.size()>0) objects.remove(0);}
//        REAPPEAR
        if(window.isKeyPressed(GLFW_KEY_O)){babayaga();}
//        SHY
//        if(window.isKeyPressed(GLFW_KEY_8)){objects.get(0).translateObject(0.0f,0.00f,0.01f);}
//        END ANIMATION


//        TRANSLATING OBJECT
//        FORWARD
        if(window.isKeyPressed(GLFW_KEY_RIGHT)){
            Vector3f objectDir = new Vector3f(0.0f, 0.0f, 1.0f);
            objects.get(0).model.transformDirection(objectDir, objectDir);
            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
            objects.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);
            waveRightHand();
            waveLeftHand();

        }
////        BACKWARD
        if(window.isKeyPressed(GLFW_KEY_LEFT)){
            Vector3f objectDir = new Vector3f(0.0f, 0.0f, -1.0f);
            objects.get(0).model.transformDirection(objectDir, objectDir);
            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
            objects.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);
            waveTail();
        }
//        ASCEND
        if(window.isKeyPressed(GLFW_KEY_UP)){objects.get(0).translateObject(0.0f,0.01f,0.0f);}
//        DESCEND
        if(window.isKeyPressed(GLFW_KEY_DOWN)){objects.get(0).translateObject(0.0f,-0.01f,0.0f);}
//        END TRANSLATING OBJECT

//        SCALING OBJECT
//        MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_M)){objects.get(0).scaleObject(1.1f,1.1f,1.1f);}
//        REVERSE MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_N)){objects.get(0).scaleObject(0.8f,0.8f,0.8f);}
//        END SCALING





        //        SCALING OBJECT  BOMBER
//        MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_B)){bomber.get(0).scaleObject(1.1f,1.1f,1.1f);}
//        REVERSE MAGNIFY
        if(window.isKeyPressed(GLFW_KEY_V)){bomber.get(0).scaleObject(0.8f,0.8f,0.8f);}
//        END SCALING

        //        ROTATING OBJECT BOMBER
        if(window.isKeyPressed(GLFW_KEY_L)){
//            Y_RIGHT
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);

            bomber.get(0).rotateObject(0.045f,0.0f,1.0f,0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);

        }
        if(window.isKeyPressed(GLFW_KEY_J)){
//            Y_LEFT
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            bomber.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,-1.0f,0.0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_K)){
//            X_UP
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            bomber.get(0).rotateObject((float)Math.toRadians(1.5f),1.0f,0.0f,0.0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_I)){
//            X_DOWN
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            bomber.get(0).rotateObject((float)Math.toRadians(1.5f),-1.0f,0.0f,0.0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_U)){
//            Z_POS
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            bomber.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,1.0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }
        if(window.isKeyPressed(GLFW_KEY_Y)){
//            Z_NEG
            Vector3f mainbody = new Vector3f(bomber.get(0).model.transformPosition(new Vector3f(0.0f,0.0f,0.0f)));
            bomber.get(0).translateObject(-mainbody.x, -mainbody.y, -mainbody.z);
            bomber.get(0).rotateObject((float)Math.toRadians(1.5f),0.0f,0.0f,-1.0f);
            bomber.get(0).translateObject(mainbody.x,mainbody.y, mainbody.z);
        }

        if(window.isKeyPressed(GLFW_KEY_0)){
            Vector3f objectDir = new Vector3f(0.0f, 0.0f, 1.0f);
            bomber.get(0).model.transformDirection(objectDir, objectDir);
            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
            bomber.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);
            bomberWalk();
        }
        if(window.isKeyPressed(GLFW_KEY_9)){
//            Vector3f objectDir = new Vector3f(0.0f, 0.0f, 1.0f);
//            bomber.get(0).model.transformDirection(objectDir, objectDir);
//            Vector3f translation = new Vector3f(objectDir).mul(0.1f);
//            bomber.get(0).translateObject(translation.x/10, translation.y/10, translation.z/10);
            bomberTail();
        }

        if(window.isKeyPressed(GLFW_KEY_8)){
            size++;
            if(size == 10){
                bomber.get(0).setColor(new Vector4f(0.0f,0.0f,0.0f,0.1f));
            }
            if(size == 20){
                bomber.get(0).setColor(new Vector4f(0.18f,0.03f,0.02f,0.2f));
            }
            if(size == 30){
                bomber.get(0).setColor(new Vector4f(0.36f,0.06f,0.04f,0.3f));
            }
            if(size == 40){
                bomber.get(0).setColor(new Vector4f(0.54f,0.09f,0.06f,0.4f));
            }
            if(size == 50){
                bomber.get(0).setColor(new Vector4f(0.72f,0.12f,0.08f,0.5f));
            }
            if(size == 60){
                bomber.get(0).setColor(new Vector4f(0.9f,0.15f,0.1f,0.6f));
            }
            if(size == 70){
                bomber.get(0).setColor(new Vector4f(1.08f,0.18f,0.12f,0.7f));
            }
            if(size == 90){
                bomber.get(0).setColor(new Vector4f(1.26f,0.21f,0.14f,0.8f));
            }
            if(size == 100){
                bomber.get(0).setColor(new Vector4f(1.44f,0.24f,0.16f,0.9f));
            }

            if(size == 200){
                bomber.get(0).setColor(new Vector4f(1.8f,0.3f,0.2f,1.0f));
            }

            if(size >= 207){
                if(checks){
                    bomber.get(0).setColor(new Vector4f(3.0f,0.0f,0.0f,0.0f));
                }
            if(size == 212){
                if(bomber.size()>0) bomber.remove(0);
                checks = false;
            }

            }
            else {
                bomber.get(0).scaleObject(1.0025f,1.0025f,1.0025f);

            }




        }
//      END ROTATING OBJECT
//        box n mush
        if (window.isKeyPressed(GLFW_KEY_E)) {
            if(count<550) {
                objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);
                objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);
                objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);

                objectsMush.get(0).translateObject(0.0f, 0.00025f, 0.0f);
                objectsBox.get(0).translateObject(0.0f, -0.0005f, 0.0f);
                objectsLine.get(0).translateObject(0.0f, -0.0005f, 0.0f);
            }
            else if(count<670){
                objectsMush.get(0).scaleObject(1.01f, 1.01f, 1.01f);
                objectsBox.get(0).scaleObject(0.99f, 0.99f, 0.99f);
                objectsLine.get(0).scaleObject(0.99f, 0.99f, 0.99f);
                objectsMush.get(0).translateObject(0.0f, -0.002f, 0.0f);
            }
            else{
                if(red <= 1.0f && green<= 1.0f) {
                    red += 0.01f;
                    green += 0.01f;
                }

            }
            count++;
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            if(count<0){
                System.out.println();
            }
            else if(count<550) {
                objectsMush.get(0).rotateObject((float) Math.toRadians(-1.27f), 0.0f, 1.0f, 0.0f);
                objectsBox.get(0).rotateObject((float) Math.toRadians(-1.27f), 0.0f, 1.0f, 0.0f);
                objectsLine.get(0).rotateObject((float) Math.toRadians(-1.27f), 0.0f, 1.0f, 0.0f);

                objectsMush.get(0).translateObject(0.0f, -0.00025f, 0.0f);
                objectsBox.get(0).translateObject(0.0f, 0.0005f, 0.0f);
                objectsLine.get(0).translateObject(0.0f, 0.0005f, 0.0f);
            }
            else if(count<670){
                objectsMush.get(0).scaleObject(0.9900990099f, 0.9900990099f, 0.9900990099f);
                objectsBox.get(0).scaleObject(1.0101010101f, 1.0101010101f, 1.0101010101f);
                objectsLine.get(0).scaleObject(1.0101010101f, 1.0101010101f, 1.0101010101f);
                objectsMush.get(0).translateObject(0.0f, 0.002f, 0.0f);
            }
            else{
                if(red >= 0.0f && green>= 0.0f) {
                    red -= 0.01f;
                    green -= 0.01f;
                }
            }
            count--;
        }


        if (window.isKeyPressed(GLFW_KEY_R)) {
            objectsBox.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

            for (Object child : objectsBox.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }
            for (Object child : objectsBox.get(0).getChildObject().get(1).getChildObject()) {
                Vector3f tempCenterPoint = objectsBox.get(0).getChildObject().get(1).updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }

            objectsMush.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

            for (Object child : objectsMush.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }
            for (Object child : objectsMush.get(0).getChildObject().get(1).getChildObject()) {
                Vector3f tempCenterPoint = objectsMush.get(0).getChildObject().get(1).updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }

            objectsLine.get(0).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

            for (Object child : objectsLine.get(0).getChildObject()) {
                Vector3f tempCenterPoint = child.updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }
            for (Object child : objectsLine.get(0).getChildObject().get(1).getChildObject()) {
                Vector3f tempCenterPoint = objectsLine.get(0).getChildObject().get(1).updateCenterPoint();

                child.translateObject(tempCenterPoint.x * -1,
                        tempCenterPoint.y * -1,
                        tempCenterPoint.z * -1);

                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);

                child.translateObject(tempCenterPoint.x * 1,
                        tempCenterPoint.y * 1,
                        tempCenterPoint.z * 1);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)&& window.isKeyPressed(GLFW_KEY_G)) {
//            Y_RIGHT
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 1.0f, 0.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_A)&& window.isKeyPressed(GLFW_KEY_G)) {
//            Y_LEFT
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, -1.0f, 0.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, -1.0f, 0.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, -1.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_S)&& window.isKeyPressed(GLFW_KEY_G)) {
//            X_UP
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 1.0f, 0.0f, 0.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 1.0f, 0.0f, 0.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_W)&& window.isKeyPressed(GLFW_KEY_G)) {
//            X_DOWN
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), -1.0f, 0.0f, 0.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), -1.0f, 0.0f, 0.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), -1.0f, 0.0f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_Z)&& window.isKeyPressed(GLFW_KEY_G)) {
//            Z_POS
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, 1.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, 1.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, 1.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_X) && window.isKeyPressed(GLFW_KEY_G)) {
//            Z_NEG
            objectsMush.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, -1.0f);
            objectsBox.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, -1.0f);
            objectsLine.get(0).rotateObject((float) Math.toRadians(1.27f), 0.0f, 0.0f, -1.0f);
        }


    }
//end tulul


    public void loop(){
        while (window.isOpen()){
            window.update();

            glClearColor(0.0f, 0.5f, 0.5f, 1.0f);
            GL.createCapabilities();
            input();
//            write your code here
//            .....
//            System.out.println("halooo");


//            boo
            for (Object object:objects){
                object.draw(camera, projection);
                object.drawIndices(camera, projection);
            }
//bob omb
            for (Object object: bomber){
                object.draw(camera, projection);
                object.drawIndices(camera, projection);
            }
//box n mush
            for (Object object : objectsMush) {
                object.draw(camera, projection);
                object.drawIndices(camera, projection);
            }
            for (Object object : objectsBox) {
                object.draw(camera, projection);
                object.drawIndices(camera, projection);
            }
            for (Object object : objectsLine) {
                object.drawLine(camera, projection);
            }


//            restore state
            glDisableVertexAttribArray(0);
            glfwPollEvents();




        }
    }

    public static void main(String[] args) {
        new project_uts().run();
//        System.out.println("done");
    }


}
