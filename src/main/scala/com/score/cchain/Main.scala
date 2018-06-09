package com.score.cchain

import akka.actor.ActorSystem
import com.score.cchain.actor.{BlockCreator, SenzActor}
import com.score.cchain.util.{ChainFactory, MinerFactory}

object Main extends App {

  // first
  //  1. setup logging
  //  2. setup keys
  ChainFactory.setupLogging()
  ChainFactory.setupKeys()
  MinerFactory.initSchema()
  MinerFactory.initIndex()

  // start senz, block creator
  implicit val system = ActorSystem("senz")
  //system.actorOf(SenzActor.props, name = "SenzActor")
  system.actorOf(BlockCreator.props, name = "BlockCreator")

}
