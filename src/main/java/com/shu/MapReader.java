package com.shu;

import com.shu.blocks.*;

import java.util.stream.Stream;

public class MapReader {

    public static Block[][] read(Stream<String> mapStream) {
        return mapStream.map(lineOfMap -> Stream.of(lineOfMap.trim().split(""))
                .map(MapReader::createBlockBySymbol)
                .toArray(Block[]::new)
        ).toArray(Block[][]::new);
    }

    private static Block createBlockBySymbol(String blockSymbol) {
        switch (blockSymbol) {
            case "r":
                return new RockyGround();
            case "T":
                return new PreservedTree();
            case "t":
                return new RemovableTree();
            default:
                return new PlainLand();
        }

    }
}
