package com.shu;

import com.shu.blocks.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Block[][] blocks = {
                {new PlainLand(), new PlainLand(), new RemovableTree(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand()},
                {new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PreservedTree(), new PlainLand(), new PlainLand()},
                {new RockyGround(), new RockyGround(), new RockyGround(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PreservedTree(), new PlainLand(), new PlainLand()},
                {new RockyGround(), new RockyGround(), new RockyGround(), new RockyGround(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand()},
                {new RockyGround(), new RockyGround(), new RockyGround(), new RockyGround(), new RockyGround(), new RemovableTree(), new PlainLand(), new PlainLand(), new PlainLand(), new PlainLand()},
        };

        new ConstructionSiteSimulator(blocks, in).start();
    }
}
