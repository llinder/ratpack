/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ratpack.http;

import io.netty.buffer.ByteBuf;
import ratpack.util.internal.IoUtils;

public class HttpResponseChunk implements StreamElement {

  private final String chunk;

  public HttpResponseChunk(String chunk) {
    this.chunk = chunk;
  }

  @Override
  public ByteBuf getValue() {
    return IoUtils.utf8Buffer(Integer.toHexString(chunk.length()) + "\r\n" + chunk + "\r\n");
  }
}