package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Circle extends Object2D{

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList, vertices, verticesColor);
    }

    public void createCircle(){
        // vertices -> clear
        for(double i =0; i<360;i+=0.0001)
        {
            //Math.round()
        }
    }
}
