/*
 * Copyright 2011-2013 Sisioh Project and others. (http://www.sisioh.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.sisioh.dddbase.lifecycle.forwarding.sync.wrapped

import org.sisioh.dddbase.core.lifecycle.EntityIOContext
import org.sisioh.dddbase.core.lifecycle.async.AsyncEntityIOContext
import org.sisioh.dddbase.core.lifecycle.sync.SyncEntityIO
import scala.util.Try

/**
 *
 */
trait SyncWrappedAsyncEntityIO extends SyncEntityIO {

  /**
   * [[org.sisioh.dddbase.core.lifecycle.EntityIOContext]]から
   * [[org.sisioh.dddbase.core.lifecycle.async.AsyncEntityIOContext]]を取得する。
   *
   * @param ctx [[org.sisioh.dddbase.core.lifecycle.EntityIOContext]]
   * @return [[org.sisioh.dddbase.core.lifecycle.async.AsyncEntityIOContext]]
   */
  protected def getAsyncEntityIOContext(ctx: EntityIOContext[Try]): AsyncEntityIOContext =
    ctx match {
      case SyncWrappedAsyncEntityIOContext(async) => async
      case _ => throw new IllegalArgumentException(s"$ctx is type miss match. please set to SyncWrappedAsyncEntityIOContext.")
    }

}