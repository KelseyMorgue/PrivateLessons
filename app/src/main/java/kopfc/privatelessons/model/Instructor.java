package kopfc.privatelessons.model;

/**
 * Created by CodyH on 10/15/15.
 */
public class Instructor
{


    private String name;
    private String email;
    private String biography;
    private String[] strokes;
    private boolean[] availability;

    public Instructor()
    {

    }

    public Instructor(String name, String email, String biography, String[] strokes, boolean[] availability)
    {
        this.name = name;
        this.email = email;
        this.biography = biography;
        this.strokes = strokes;
        this.availability = availability;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String[] getStrokes()
    {
        return strokes;
    }

    public void setStrokes(String[] strokes)
    {
        this.strokes = strokes;
    }

    public boolean[] getAvailability()
    {
        return availability;
    }

    public void setAvailability(boolean[] availability)
    {
        this.availability = availability;
    }


}
