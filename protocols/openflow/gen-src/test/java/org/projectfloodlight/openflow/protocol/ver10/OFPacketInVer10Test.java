// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template unit_test.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver10;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.bsntlv.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.hamcrest.CoreMatchers;



public class OFPacketInVer10Test {
    OFFactory factory;

    final static byte[] PACKET_IN_SERIALIZED =
        new byte[] { 0x1, 0xa, 0x0, 0x15, 0x12, 0x34, 0x56, 0x78, (byte) 0xab, (byte) 0xcd, (byte) 0xef, 0x1, 0x0, 0x9, (byte) 0xff, (byte) 0xfe, 0x1, 0x0, 0x61, 0x62, 0x63 };

    @Before
    public void setup() {
        factory = OFFactoryVer10.INSTANCE;
    }

    @Test
    public void testWrite() {
        OFPacketIn.Builder builder = factory.buildPacketIn();
        builder
   .setXid(0x12345678)
   .setBufferId(OFBufferId.of(0xabcdef01))
   .setTotalLen(9)
   .setInPort(OFPort.LOCAL)
   .setReason(OFPacketInReason.ACTION)
   .setData(new byte[] { 0x61, 0x62, 0x63 } );;
        OFPacketIn packetIn = builder.build();
        ByteBuf bb = Unpooled.buffer();
        packetIn.writeTo(bb);
        byte[] written = new byte[bb.readableBytes()];
        bb.readBytes(written);

        assertThat(written, CoreMatchers.equalTo(PACKET_IN_SERIALIZED));
    }

    @Test
    public void testRead() throws Exception {
        OFPacketIn.Builder builder = factory.buildPacketIn();
        builder
   .setXid(0x12345678)
   .setBufferId(OFBufferId.of(0xabcdef01))
   .setTotalLen(9)
   .setInPort(OFPort.LOCAL)
   .setReason(OFPacketInReason.ACTION)
   .setData(new byte[] { 0x61, 0x62, 0x63 } );;
        OFPacketIn packetInBuilt = builder.build();

        ByteBuf input = Unpooled.copiedBuffer(PACKET_IN_SERIALIZED);

        // FIXME should invoke the overall reader once implemented
        OFPacketIn packetInRead = OFPacketInVer10.READER.readFrom(input);
        assertEquals(PACKET_IN_SERIALIZED.length, input.readerIndex());

        assertEquals(packetInBuilt, packetInRead);
   }

   @Test
   public void testReadWrite() throws Exception {
       ByteBuf input = Unpooled.copiedBuffer(PACKET_IN_SERIALIZED);

       // FIXME should invoke the overall reader once implemented
       OFPacketIn packetIn = OFPacketInVer10.READER.readFrom(input);
       assertEquals(PACKET_IN_SERIALIZED.length, input.readerIndex());

       // write message again
       ByteBuf bb = Unpooled.buffer();
       packetIn.writeTo(bb);
       byte[] written = new byte[bb.readableBytes()];
       bb.readBytes(written);

       assertThat(written, CoreMatchers.equalTo(PACKET_IN_SERIALIZED));
   }

}