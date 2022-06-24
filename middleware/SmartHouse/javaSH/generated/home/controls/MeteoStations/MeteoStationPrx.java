//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `device.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package home.controls.MeteoStations;

public interface MeteoStationPrx extends home.controls.TempControlPrx
{
    default Sensor readSensor(int id)
    {
        return readSensor(id, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Sensor readSensor(int id, java.util.Map<String, String> context)
    {
        return _iceI_readSensorAsync(id, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Sensor> readSensorAsync(int id)
    {
        return _iceI_readSensorAsync(id, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Sensor> readSensorAsync(int id, java.util.Map<String, String> context)
    {
        return _iceI_readSensorAsync(id, context, false);
    }

    /**
     * @hidden
     * @param iceP_id -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Sensor> _iceI_readSensorAsync(int iceP_id, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Sensor> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readSensor", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeInt(iceP_id);
                 }, istr -> {
                     Sensor ret;
                     ret = Sensor.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default Sensor[] readSensors()
    {
        return readSensors(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Sensor[] readSensors(java.util.Map<String, String> context)
    {
        return _iceI_readSensorsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Sensor[]> readSensorsAsync()
    {
        return _iceI_readSensorsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Sensor[]> readSensorsAsync(java.util.Map<String, String> context)
    {
        return _iceI_readSensorsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Sensor[]> _iceI_readSensorsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Sensor[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readSensors", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Sensor[] ret;
                     ret = SensorSequenceHelper.read(istr);
                     return ret;
                 });
        return f;
    }

    default home.DateTime readDate()
    {
        return readDate(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default home.DateTime readDate(java.util.Map<String, String> context)
    {
        return _iceI_readDateAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<home.DateTime> readDateAsync()
    {
        return _iceI_readDateAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<home.DateTime> readDateAsync(java.util.Map<String, String> context)
    {
        return _iceI_readDateAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<home.DateTime> _iceI_readDateAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<home.DateTime> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readDate", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     home.DateTime ret;
                     ret = home.DateTime.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default LunarPhase readLunarPhase()
    {
        return readLunarPhase(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default LunarPhase readLunarPhase(java.util.Map<String, String> context)
    {
        return _iceI_readLunarPhaseAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<LunarPhase> readLunarPhaseAsync()
    {
        return _iceI_readLunarPhaseAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<LunarPhase> readLunarPhaseAsync(java.util.Map<String, String> context)
    {
        return _iceI_readLunarPhaseAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<LunarPhase> _iceI_readLunarPhaseAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<LunarPhase> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readLunarPhase", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     LunarPhase ret;
                     ret = LunarPhase.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default float readHumidity()
    {
        return readHumidity(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default float readHumidity(java.util.Map<String, String> context)
    {
        return _iceI_readHumidityAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> readHumidityAsync()
    {
        return _iceI_readHumidityAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> readHumidityAsync(java.util.Map<String, String> context)
    {
        return _iceI_readHumidityAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> _iceI_readHumidityAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readHumidity", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     float ret;
                     ret = istr.readFloat();
                     return ret;
                 });
        return f;
    }

    default float readPressure()
    {
        return readPressure(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default float readPressure(java.util.Map<String, String> context)
    {
        return _iceI_readPressureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> readPressureAsync()
    {
        return _iceI_readPressureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Float> readPressureAsync(java.util.Map<String, String> context)
    {
        return _iceI_readPressureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> _iceI_readPressureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Float> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "readPressure", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     float ret;
                     ret = istr.readFloat();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MeteoStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MeteoStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MeteoStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static MeteoStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static MeteoStationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static MeteoStationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, MeteoStationPrx.class, _MeteoStationPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default MeteoStationPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (MeteoStationPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default MeteoStationPrx ice_adapterId(String newAdapterId)
    {
        return (MeteoStationPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default MeteoStationPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (MeteoStationPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default MeteoStationPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (MeteoStationPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default MeteoStationPrx ice_invocationTimeout(int newTimeout)
    {
        return (MeteoStationPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default MeteoStationPrx ice_connectionCached(boolean newCache)
    {
        return (MeteoStationPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default MeteoStationPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (MeteoStationPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default MeteoStationPrx ice_secure(boolean b)
    {
        return (MeteoStationPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default MeteoStationPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (MeteoStationPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default MeteoStationPrx ice_preferSecure(boolean b)
    {
        return (MeteoStationPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default MeteoStationPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (MeteoStationPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default MeteoStationPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (MeteoStationPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default MeteoStationPrx ice_collocationOptimized(boolean b)
    {
        return (MeteoStationPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default MeteoStationPrx ice_twoway()
    {
        return (MeteoStationPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default MeteoStationPrx ice_oneway()
    {
        return (MeteoStationPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default MeteoStationPrx ice_batchOneway()
    {
        return (MeteoStationPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default MeteoStationPrx ice_datagram()
    {
        return (MeteoStationPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default MeteoStationPrx ice_batchDatagram()
    {
        return (MeteoStationPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default MeteoStationPrx ice_compress(boolean co)
    {
        return (MeteoStationPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default MeteoStationPrx ice_timeout(int t)
    {
        return (MeteoStationPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default MeteoStationPrx ice_connectionId(String connectionId)
    {
        return (MeteoStationPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default MeteoStationPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (MeteoStationPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::home::controls::MeteoStations::MeteoStation";
    }
}
