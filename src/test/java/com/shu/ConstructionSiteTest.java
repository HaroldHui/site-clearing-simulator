package com.shu;

import com.shu.blocks.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ConstructionSiteTest {

    private final AbstractBlock[][] blocks = {
            {new PlainLand(), new PreservedTree()},
            {new RemovableTree(), new RockyGround()},
            {new PlainLand(), new VisitedBlock()},
    };
    private final ConstructionSite constructionSite = new ConstructionSite(blocks);

    @Test
    @DisplayName("When check onsite for a valid position, it should return true")
    void isOnSiteValid() {
        Position position = new Position(0, 0, Facing.NORTH);
        boolean onSite = constructionSite.isOnSite(position);

        assertThat(onSite).isEqualTo(true);
    }

    @Test
    @DisplayName("When check onsite for an invalid position, it should return false")
    void isOnSiteInValid() {
        Position position = new Position(2, 0, Facing.NORTH);
        boolean onSite = constructionSite.isOnSite(position);

        assertThat(onSite).isEqualTo(false);
    }

    @Test
    @DisplayName("When execute toString function, it should return a correct String")
    void toStringCorrect() {
        String siteString = constructionSite.toString();

        String expectedSiteString = "o T" + System.lineSeparator()
                + "t r" + System.lineSeparator()
                + "o V";

        assertThat(siteString).isEqualTo(expectedSiteString);
    }
}