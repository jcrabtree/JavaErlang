// Copyright (c) 2011, Lars-Ake Fredlund
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//     // Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//     // Redistributions in binary form must reproduce the above copyright
//       notice, this list of conditions and the following disclaimer in the
//       documentation and/or other materials provided with the distribution.
//     // Neither the name of the copyright holders nor the
//       names of its contributors may be used to endorse or promote products
//       derived from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ''AS IS''
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
// BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
// BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
// WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
// OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
// ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

// @author Lars-Ake Fredlund (lfredlund@fi.upm.es)
// @copyright 2011 Lars-Ake Fredlund
// 

package javaErlang;

import java.util.HashMap;
import java.util.Map;

import com.ericsson.otp.erlang.OtpErlangObject;

public class ErlangTypeMapper {
    public Map<RefEqualsObject, OtpErlangObject> toErlangMap;
    public Map<OtpErlangObject, Object> fromErlangMap;

    public ErlangTypeMapper() {
        toErlangMap = new HashMap<RefEqualsObject, OtpErlangObject>();
        fromErlangMap = new HashMap<OtpErlangObject, Object>();
    }

    public void reset() {
        toErlangMap.clear();
        fromErlangMap.clear();
    }

    public Object getFrom(final OtpErlangObject otpErlangObject) {
        return fromErlangMap.get(otpErlangObject);
    }

    public OtpErlangObject getTo(final RefEqualsObject obj_key) {
        return toErlangMap.get(obj_key);
    }

    public void putTo(final RefEqualsObject obj_key,
            final OtpErlangObject erlangKey) {
        toErlangMap.put(obj_key, erlangKey);
    }

    public void putFrom(final OtpErlangObject erlangKey, final Object obj) {
        fromErlangMap.put(erlangKey, obj);
    }

    public Object removeFrom(final OtpErlangObject arg) {
        return fromErlangMap.remove(arg);
    }

    public OtpErlangObject removeTo(final RefEqualsObject obj_key) {
        return toErlangMap.remove(obj_key);
    }
}
