package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class HelloWorldCommentedJack extends OpMode {

    @Override

    public void init() {
        telemetry.addData("Hello","World");
    }
    public void loop() {
    }
}
