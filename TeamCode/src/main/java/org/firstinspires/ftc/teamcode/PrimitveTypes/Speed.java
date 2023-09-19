package org.firstinspires.ftc.teamcode.PrimitveTypes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Speed extends OpMode {
    @Override
    public void init() {

    }
    @Override
    public void loop (){
        double speedForward = -gamepad1.left_stick_y / 2.0;
        telemetry.addData("left stick", gamepad1.left_stick_y);
        telemetry.addData("speed Forward", speedForward);
    }
}
