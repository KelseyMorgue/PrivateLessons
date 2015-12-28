package kopfc.privatelessons;

import android.app.FragmentManager;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class PrivateLessonsActivity extends ActionBarActivity
{

    private String[] drawerContents;
    private DrawerLayout mainLayout;
    private ListView drawerList;
    private Button schedButton, classesButton, drillsButton, biosButton, paymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_lessons);

        drawerContents = getResources().getStringArray(R.array.mainDrawerContents);
        drawerList = (ListView) findViewById(R.id.leftDrawer);
        mainLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerContents));
    }

    private void setupListeners()
    {
        schedButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //opens the scheduing part of the app
                //New activity
            }
        });

        classesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //names of the classesButton and the entry skills are for that class

            }
        });

        drillsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //open drills page - should have text description of drills for each stroke.
                //new activity or webpage
            }
        });

        biosButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Open bios activity
            }
        });

        paymentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Open link to KOPFC payment page here.
                //Future option - add selection to private lesson as part of URL passing??

                Toast.makeText(v.getContext(), getText(R.string.reminder), Toast.LENGTH_LONG).show();
                String urlKOPFC = "http://www.activityreg.com/selectactivity.wcs";
                Intent paymentIntent = new Intent(Intent.ACTION_VIEW);
                paymentIntent.setData(Uri.parse(urlKOPFC));
                Toast.makeText(v.getContext(), "Choose the + sign by water activities for lessons", Toast.LENGTH_SHORT).show();
                startActivity(paymentIntent);

            }
        });

        drawerList.setOnItemClickListener(new ListView.OnItemClickListener()
        {
            public void onItemClick(AdapterView parent, View view, int position, long id)
            {
                selectItem(position);
            }
        });

    }

    /**
     * Swap the fragment in the FrameLayout based on the position in the DrawerList.
     * @param position The selection by the user from the DrawerList.
     */
    private void selectItem(int position)
    {
        Fragment lessonFragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putInt(LessonFragment.ARG_LESSON_MENU, position);
        lessonFragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.contentFrame, lessonFragment)
                       .commit();
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_private_lessons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
