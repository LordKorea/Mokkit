package de.fuchspfoten.mokkit;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * A chunk coordinate.
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class ChunkCoordinate {

    /**
     * The x coordinate.
     */
    private @Getter final int x;

    /**
     * The z coordinate.
     */
    private @Getter final int z;
}
