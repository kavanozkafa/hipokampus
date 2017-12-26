package sammas.hipokampus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Game extends AppCompatActivity {

    int ROW = -1;
    int COL = -1;

    Context context;
    Drawable backImage;
    int [] [] cards;
    List<Drawable> images;

    Card firstCard;
    Card secondCard;

    ButtonListener buttonListener;


    Object lock = new Object();

    int turns;
    TableLayout mainTable;
    UpdateCardsHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        handler = new UpdateCardsHandler();
        backImage =  getResources().getDrawable(R.drawable.icon);
        buttonListener = new ButtonListener();
        mainTable = (TableLayout)findViewById(R.id.TableLayout);
        context  = mainTable.getContext();

        Spinner s = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        Spinner ss = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.cesit, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ss.setAdapter(adapter2);

        //kart secimi
        ss.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i) {
                    case 1:

                        loadFutbolImages();
                        break;
                    case 2:
                        loadPokemonImages();
                        break;
                    case 3:
                        loadUlkeImages();
                        break;
                    case 4:
                        loadNBAImages();
                        break;
                    case 5:
                        loadProgrammingImages();
                        break;
                    default:
                        return;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
      //oyun zorlugu secimi
        s.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((Spinner) findViewById(R.id.Spinner01)).setSelection(0);

                int x,y;

                switch (i) {
                    case 1:
                        x=4;y=4;


                        break;
                    case 2:
                        x=6;y=4;

                        break;
                    case 3:
                        x=6;y=6;

                        break;
                    default:
                        return;
                }
                newGame(x,y);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    //oyun zorlugu
    public void newGame(int c, int r) {
        ROW = r;
        COL = c;

        cards = new int [COL] [ROW];

        TableRow tr = ((TableRow)findViewById(R.id.TableRow03));
        tr.removeAllViews();

        mainTable = new TableLayout(context);
        tr.addView(mainTable);

        for (int y = 0; y < ROW; y++) {
            mainTable.addView(createRow(y));
        }

        firstCard=null;
        loadCards();

        turns=0;
        ((TextView)findViewById(R.id.tv1)).setText("Deneme Sayısı:  "+turns);


    }

    //kart türleri
    public void loadFutbolImages() {


        images = new ArrayList<Drawable>();


        images.add(getResources().getDrawable(R.drawable.card1));
        images.add(getResources().getDrawable(R.drawable.card2));
        images.add(getResources().getDrawable(R.drawable.card3));
        images.add(getResources().getDrawable(R.drawable.card4));
        images.add(getResources().getDrawable(R.drawable.card5));
        images.add(getResources().getDrawable(R.drawable.card6));
        images.add(getResources().getDrawable(R.drawable.card7));
        images.add(getResources().getDrawable(R.drawable.card8));
        images.add(getResources().getDrawable(R.drawable.card9));
        images.add(getResources().getDrawable(R.drawable.card10));
        images.add(getResources().getDrawable(R.drawable.card11));
        images.add(getResources().getDrawable(R.drawable.card12));
        images.add(getResources().getDrawable(R.drawable.card13));
        images.add(getResources().getDrawable(R.drawable.card14));
        images.add(getResources().getDrawable(R.drawable.card15));
        images.add(getResources().getDrawable(R.drawable.card16));
        images.add(getResources().getDrawable(R.drawable.card17));
        images.add(getResources().getDrawable(R.drawable.card18));
        images.add(getResources().getDrawable(R.drawable.card19));
        images.add(getResources().getDrawable(R.drawable.card20));


    }
    public void loadPokemonImages() {

        images = new ArrayList<Drawable>();


        images.add(getResources().getDrawable(R.drawable.card21));
        images.add(getResources().getDrawable(R.drawable.card22));
        images.add(getResources().getDrawable(R.drawable.card23));
        images.add(getResources().getDrawable(R.drawable.card24));
        images.add(getResources().getDrawable(R.drawable.card25));
        images.add(getResources().getDrawable(R.drawable.card26));
        images.add(getResources().getDrawable(R.drawable.card27));
        images.add(getResources().getDrawable(R.drawable.card28));
        images.add(getResources().getDrawable(R.drawable.card29));
        images.add(getResources().getDrawable(R.drawable.card30));
        images.add(getResources().getDrawable(R.drawable.card31));
        images.add(getResources().getDrawable(R.drawable.card32));
        images.add(getResources().getDrawable(R.drawable.card33));
        images.add(getResources().getDrawable(R.drawable.card34));
        images.add(getResources().getDrawable(R.drawable.card35));
        images.add(getResources().getDrawable(R.drawable.card36));
        images.add(getResources().getDrawable(R.drawable.card37));
        images.add(getResources().getDrawable(R.drawable.card38));
    }
    public void loadUlkeImages() {

        images = new ArrayList<Drawable>();


        images.add(getResources().getDrawable(R.drawable.albania));
        images.add(getResources().getDrawable(R.drawable.azerbaijan));
        images.add(getResources().getDrawable(R.drawable.bosnian));
        images.add(getResources().getDrawable(R.drawable.croatian));
        images.add(getResources().getDrawable(R.drawable.greece));
        images.add(getResources().getDrawable(R.drawable.kosovo));
        images.add(getResources().getDrawable(R.drawable.macedonia));
        images.add(getResources().getDrawable(R.drawable.moldova));
        images.add(getResources().getDrawable(R.drawable.montenegro));
        images.add(getResources().getDrawable(R.drawable.netherlands));
        images.add(getResources().getDrawable(R.drawable.norway));
        images.add(getResources().getDrawable(R.drawable.portugal));
        images.add(getResources().getDrawable(R.drawable.serbia));
        images.add(getResources().getDrawable(R.drawable.spain));
        images.add(getResources().getDrawable(R.drawable.sweden));
        images.add(getResources().getDrawable(R.drawable.switzerland));
        images.add(getResources().getDrawable(R.drawable.turkey));
        images.add(getResources().getDrawable(R.drawable.uk));
    }
    public void loadNBAImages() {

        images = new ArrayList<Drawable>();


        images.add(getResources().getDrawable(R.drawable.nba1));
        images.add(getResources().getDrawable(R.drawable.nba2));
        images.add(getResources().getDrawable(R.drawable.nba3));
        images.add(getResources().getDrawable(R.drawable.nba4));
        images.add(getResources().getDrawable(R.drawable.nba5));
        images.add(getResources().getDrawable(R.drawable.nba6));
        images.add(getResources().getDrawable(R.drawable.nba7));
        images.add(getResources().getDrawable(R.drawable.nba8));
        images.add(getResources().getDrawable(R.drawable.nba9));
        images.add(getResources().getDrawable(R.drawable.nba10));
        images.add(getResources().getDrawable(R.drawable.nba11));
        images.add(getResources().getDrawable(R.drawable.nba12));
        images.add(getResources().getDrawable(R.drawable.nba13));
        images.add(getResources().getDrawable(R.drawable.nba14));
        images.add(getResources().getDrawable(R.drawable.nba15));
        images.add(getResources().getDrawable(R.drawable.nba16));
        images.add(getResources().getDrawable(R.drawable.nba17));
        images.add(getResources().getDrawable(R.drawable.nba18));
    }
    public void loadProgrammingImages() {

        images = new ArrayList<Drawable>();


        images.add(getResources().getDrawable(R.drawable.pl1));
        images.add(getResources().getDrawable(R.drawable.pl2));
        images.add(getResources().getDrawable(R.drawable.pl3));
        images.add(getResources().getDrawable(R.drawable.pl4));
        images.add(getResources().getDrawable(R.drawable.pl5));
        images.add(getResources().getDrawable(R.drawable.pl6));
        images.add(getResources().getDrawable(R.drawable.pl7));
        images.add(getResources().getDrawable(R.drawable.pl8));
        images.add(getResources().getDrawable(R.drawable.pl9));
        images.add(getResources().getDrawable(R.drawable.pl10));
        images.add(getResources().getDrawable(R.drawable.pl11));
        images.add(getResources().getDrawable(R.drawable.pl12));
        images.add(getResources().getDrawable(R.drawable.pl13));
        images.add(getResources().getDrawable(R.drawable.pl14));
        images.add(getResources().getDrawable(R.drawable.pl15));
        images.add(getResources().getDrawable(R.drawable.pl16));
        images.add(getResources().getDrawable(R.drawable.pl17));
        images.add(getResources().getDrawable(R.drawable.pl18));
    }

    private void loadCards(){
        try{
            int size = ROW*COL;

            ArrayList<Integer> list = new ArrayList<Integer>();

            for(int i=0;i<size;i++){
                list.add(new Integer(i));
            }


            Random r = new Random();

            for(int i=size-1;i>=0;i--){
                int t=0;

                if(i>0){
                    t = r.nextInt(i);
                }

                t= list.remove(t);
                cards[i%COL][i/COL]=t%(size/2);

            }
        }
        catch (Exception e) {

        }

    }

    //yeni oyun icin alan yaratılması
    private TableRow createRow(int y){
        TableRow row = new TableRow(context);
        row.setHorizontalGravity(Gravity.CENTER);

        for (int x = 0; x < COL; x++) {
            row.addView(createImageButton(x,y));
        }
        return row;
    }

    private View createImageButton(int x, int y){
        Button button = new Button(context);
        button.setBackgroundDrawable(backImage);
        button.setId(100*x+y);
        button.setOnClickListener(buttonListener);
        return button;
    }

    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {

            synchronized (lock) {
                if(firstCard!=null && secondCard != null){
                    return;
                }
                int id = v.getId();
                int x = id/100;
                int y = id%100;
                turnCard((Button)v,x,y);
            }

        }

        public void turnCard(Button button,int x, int y) {
            button.setBackgroundDrawable(images.get(cards[x][y]));

            if(firstCard==null){
                firstCard = new Card(button,x,y);
            }
            else{

                if(firstCard.x == x && firstCard.y == y){
                    return;
                }

                secondCard = new Card(button,x,y);

                turns++;
                ((TextView)findViewById(R.id.tv1)).setText("Deneme Sayısı:  "+turns);



                TimerTask tt = new TimerTask() {

                    @Override
                    public void run() {
                        try{
                            synchronized (lock) {
                                handler.sendEmptyMessage(0);
                            }
                        }
                        catch (Exception e) {

                        }
                    }
                };

                Timer t = new Timer(false);
                t.schedule(tt,500);
            }


        }

    }

    class UpdateCardsHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            synchronized (lock) {
                checkCards();
            }
        }

        public void checkCards(){
            if(cards[secondCard.x][secondCard.y] == cards[firstCard.x][firstCard.y]){
                firstCard.button.setVisibility(View.INVISIBLE);
                secondCard.button.setVisibility(View.INVISIBLE);
            }
            else {
                secondCard.button.setBackgroundDrawable(backImage);
                firstCard.button.setBackgroundDrawable(backImage);
            }

            firstCard=null;
            secondCard=null;
        }
    }




}
