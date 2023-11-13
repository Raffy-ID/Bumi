import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class EarthView extends View {
    private Paint paint;
    private int earthX; // posisi horizontal Bumi

    public EarthView(Context context) {
        super(context);
        paint = new Paint();
        earthX = getWidth(); // mulai dari kanan
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int y = getHeight();
        int radius = 100;

        // Gambar Bumi
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#0000FF")); // Biru tua untuk air
        canvas.drawCircle(earthX, y / 2, radius, paint);

        // Gambar benua
        paint.setColor(Color.parseColor("#008000")); // Hijau tua untuk benua
        canvas.drawArc(earthX - radius, y / 2 - radius, earthX + radius, y / 2 + radius, -30, 60, true, paint); // Eropa dan Asia
        canvas.drawArc(earthX - radius, y / 2 - radius, earthX + radius, y / 2 + radius, 60, 30, true, paint); // Timur Tengah

        // Gambar gunung
        paint.setColor(Color.parseColor("#A9A9A9")); // Abu-abu untuk gunung
        canvas.drawLine(earthX, y / 2, earthX - 20, y / 2 + 20, paint); // Segitiga untuk gunung
        canvas.drawLine(earthX, y / 2, earthX + 20, y / 2 + 20, paint); // Segitiga untuk gunung

        // Rotasi Bumi
        earthX -= 10; // gerakkan Bumi 10 pixel ke kiri

        // Redraw view
        invalidate();
    }
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EarthView earthView = new EarthView(this);
    setContentView(earthView);
}
