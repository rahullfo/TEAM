
/*
 * Copyright 1997-2007 Markus Hahn.
 * For licensing information please read the README.TXT and contact the author. 
 */

package org.ariose.util;

/** The very base class. Just the carrier of some definitions independent of
 * the actual mode of operation. */
public class Enc
{
    /** The maximum possible key length in bytes. The minimum is zero. */
    public final static int MAXKEYLENGTH = 56;

    /** The block size of the Blowfish cipher in bytes. */
    public final static int BLOCKSIZE = 8;
}
