package org.example.infrastructure.data.utils.guests;

import org.example.infrastructure.data.utils.FunclubTestBase;
import org.junit.Test;

public abstract class  SimpleGuestsTest extends FunclubTestBase {



    @Test
    public void testOpenFirstArticle(){
        mainPage.
                openArticle().
                checkArticleTitle().
                checkArticleWriter();

    }
    @Test
    public void testListOfArticles(){

    }
    @Test
    public void testSearchOnSide(){

    }
}
