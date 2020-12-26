package frc.robot;

// All constants go here 
public final class Constants {
    // All controller constants go here
    public static class Controller {
        // Channels
        public static int MAIN_CONTROLLER_CHANNEL = 0;
    }

    // All drive subsystem constants go here
    public static class Drive {
        // Ports and channels
        public static int DRIVE_GYRO_CHANNEL = 0;
        public static int DRIVE_LEFT_MOTOR_ID = 0;
        public static int DRIVE_RIGHT_MOTOR_ID = 1;
        public static int DRIVE_ENCODER_CHANNEL_A = 0;
        public static int DRIVE_ENCODER_CHANNEL_B = 1;

        // For tuning 
        public static double DRIVE_STRAIGHT_KP = 0;
        public static double DRIVE_STRAIGHT_KI = 0;
        public static double DRIVE_STRAIGHT_KD = 0;

        public static double DRIVE_DISTANCE_KP = 0;
        public static double DRIVE_DISTANCE_KI = 0;
        public static double DRIVE_DISTANCE_KD = 0;

        // Other Constants
        public static double DRIVE_WHEEL_RADIUS = 0.0254; // Units are METERS
        public static double DRIVE_ENCODER_RESOLUTION = 8192;
    }
}
