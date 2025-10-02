public class Card
{
    private String term; 
    private String definition;

    public Card(String term, String definition)
    {
        if(term == null || term.isEmpty() || definition == null || definition.isEmpty())
        {
            throw new IllegalArgumentException("Term and definition cannot be null or empty");
        }
        this.definition = definition;
        this.term = term;

    }

    @Override
    public String toString()
    {
        return definition;
    }

    public boolean attempt (String response)
    {
        if(response == null)
        {
            return false;
        }
        return response.toUpperCase().equals(term.toUpperCase());
    }

    public String getTerm()
    {
        return term;
    }
}//push 3