// Copyright 2021 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.java;

import com.google.devtools.build.lib.analysis.TransitiveInfoProvider;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;
import com.google.devtools.build.lib.rules.cpp.CcInfo;
import com.google.devtools.build.lib.skyframe.serialization.autocodec.AutoCodec;

/** Provides information about C++ libraries to be linked into Java targets. */
@Immutable
@AutoCodec
public class JavaCcInfoProvider implements TransitiveInfoProvider {

  // TODO(b/183579145): Replace CcInfo with only linking information.
  private final CcInfo ccInfo;

  public CcInfo getCcInfo() {
    return ccInfo;
  }

  @AutoCodec.VisibleForSerialization
  public JavaCcInfoProvider(CcInfo ccInfo) {
    this.ccInfo = ccInfo;
  }
}
