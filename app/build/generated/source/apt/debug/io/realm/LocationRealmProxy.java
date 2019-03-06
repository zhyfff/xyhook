package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class LocationRealmProxy extends com.Realm.entry.Location
    implements RealmObjectProxy, LocationRealmProxyInterface {

    static final class LocationColumnInfo extends ColumnInfo {
        long idIndex;
        long idNameIndex;
        long provinceIndex;
        long cityIndex;
        long areaIndex;
        long endPageIndex;

        LocationColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Location");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.idNameIndex = addColumnDetails("idName", objectSchemaInfo);
            this.provinceIndex = addColumnDetails("province", objectSchemaInfo);
            this.cityIndex = addColumnDetails("city", objectSchemaInfo);
            this.areaIndex = addColumnDetails("area", objectSchemaInfo);
            this.endPageIndex = addColumnDetails("endPage", objectSchemaInfo);
        }

        LocationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LocationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LocationColumnInfo src = (LocationColumnInfo) rawSrc;
            final LocationColumnInfo dst = (LocationColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.idNameIndex = src.idNameIndex;
            dst.provinceIndex = src.provinceIndex;
            dst.cityIndex = src.cityIndex;
            dst.areaIndex = src.areaIndex;
            dst.endPageIndex = src.endPageIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("id");
        fieldNames.add("idName");
        fieldNames.add("province");
        fieldNames.add("city");
        fieldNames.add("area");
        fieldNames.add("endPage");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private LocationColumnInfo columnInfo;
    private ProxyState<com.Realm.entry.Location> proxyState;

    LocationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LocationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.Realm.entry.Location>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$idName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idNameIndex);
    }

    @Override
    public void realmSet$idName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$province() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.provinceIndex);
    }

    @Override
    public void realmSet$province(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.provinceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.provinceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.provinceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.provinceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$city() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cityIndex);
    }

    @Override
    public void realmSet$city(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$area() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.areaIndex);
    }

    @Override
    public void realmSet$area(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.areaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.areaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.areaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.areaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$endPage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.endPageIndex);
    }

    @Override
    public void realmSet$endPage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.endPageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.endPageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.endPageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.endPageIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Location", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("idName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("province", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("city", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("area", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("endPage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LocationColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LocationColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Location";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.Realm.entry.Location createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.Realm.entry.Location obj = null;
        if (update) {
            Table table = realm.getTable(com.Realm.entry.Location.class);
            LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.Location.class), false, Collections.<String> emptyList());
                    obj = new io.realm.LocationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.LocationRealmProxy) realm.createObjectInternal(com.Realm.entry.Location.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.LocationRealmProxy) realm.createObjectInternal(com.Realm.entry.Location.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final LocationRealmProxyInterface objProxy = (LocationRealmProxyInterface) obj;
        if (json.has("idName")) {
            if (json.isNull("idName")) {
                objProxy.realmSet$idName(null);
            } else {
                objProxy.realmSet$idName((String) json.getString("idName"));
            }
        }
        if (json.has("province")) {
            if (json.isNull("province")) {
                objProxy.realmSet$province(null);
            } else {
                objProxy.realmSet$province((String) json.getString("province"));
            }
        }
        if (json.has("city")) {
            if (json.isNull("city")) {
                objProxy.realmSet$city(null);
            } else {
                objProxy.realmSet$city((String) json.getString("city"));
            }
        }
        if (json.has("area")) {
            if (json.isNull("area")) {
                objProxy.realmSet$area(null);
            } else {
                objProxy.realmSet$area((String) json.getString("area"));
            }
        }
        if (json.has("endPage")) {
            if (json.isNull("endPage")) {
                objProxy.realmSet$endPage(null);
            } else {
                objProxy.realmSet$endPage((String) json.getString("endPage"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.Realm.entry.Location createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.Realm.entry.Location obj = new com.Realm.entry.Location();
        final LocationRealmProxyInterface objProxy = (LocationRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("idName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$idName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$idName(null);
                }
            } else if (name.equals("province")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$province((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$province(null);
                }
            } else if (name.equals("city")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$city((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$city(null);
                }
            } else if (name.equals("area")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$area((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$area(null);
                }
            } else if (name.equals("endPage")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$endPage((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$endPage(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.Realm.entry.Location copyOrUpdate(Realm realm, com.Realm.entry.Location object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.Location) cachedRealmObject;
        }

        com.Realm.entry.Location realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.Realm.entry.Location.class);
            LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((LocationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.Location.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.LocationRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.Realm.entry.Location copy(Realm realm, com.Realm.entry.Location newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.Location) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.Realm.entry.Location realmObject = realm.createObjectInternal(com.Realm.entry.Location.class, ((LocationRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        LocationRealmProxyInterface realmObjectSource = (LocationRealmProxyInterface) newObject;
        LocationRealmProxyInterface realmObjectCopy = (LocationRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$idName(realmObjectSource.realmGet$idName());
        realmObjectCopy.realmSet$province(realmObjectSource.realmGet$province());
        realmObjectCopy.realmSet$city(realmObjectSource.realmGet$city());
        realmObjectCopy.realmSet$area(realmObjectSource.realmGet$area());
        realmObjectCopy.realmSet$endPage(realmObjectSource.realmGet$endPage());
        return realmObject;
    }

    public static long insert(Realm realm, com.Realm.entry.Location object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((LocationRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$idName = ((LocationRealmProxyInterface) object).realmGet$idName();
        if (realmGet$idName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idNameIndex, rowIndex, realmGet$idName, false);
        }
        String realmGet$province = ((LocationRealmProxyInterface) object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        }
        String realmGet$city = ((LocationRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        }
        String realmGet$area = ((LocationRealmProxyInterface) object).realmGet$area();
        if (realmGet$area != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
        }
        String realmGet$endPage = ((LocationRealmProxyInterface) object).realmGet$endPage();
        if (realmGet$endPage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endPageIndex, rowIndex, realmGet$endPage, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.Realm.entry.Location object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.Location) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((LocationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$idName = ((LocationRealmProxyInterface) object).realmGet$idName();
            if (realmGet$idName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idNameIndex, rowIndex, realmGet$idName, false);
            }
            String realmGet$province = ((LocationRealmProxyInterface) object).realmGet$province();
            if (realmGet$province != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
            }
            String realmGet$city = ((LocationRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            }
            String realmGet$area = ((LocationRealmProxyInterface) object).realmGet$area();
            if (realmGet$area != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
            }
            String realmGet$endPage = ((LocationRealmProxyInterface) object).realmGet$endPage();
            if (realmGet$endPage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endPageIndex, rowIndex, realmGet$endPage, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.Realm.entry.Location object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((LocationRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$idName = ((LocationRealmProxyInterface) object).realmGet$idName();
        if (realmGet$idName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idNameIndex, rowIndex, realmGet$idName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idNameIndex, rowIndex, false);
        }
        String realmGet$province = ((LocationRealmProxyInterface) object).realmGet$province();
        if (realmGet$province != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
        }
        String realmGet$city = ((LocationRealmProxyInterface) object).realmGet$city();
        if (realmGet$city != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
        }
        String realmGet$area = ((LocationRealmProxyInterface) object).realmGet$area();
        if (realmGet$area != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.areaIndex, rowIndex, false);
        }
        String realmGet$endPage = ((LocationRealmProxyInterface) object).realmGet$endPage();
        if (realmGet$endPage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.endPageIndex, rowIndex, realmGet$endPage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.endPageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.Location.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.Realm.entry.Location object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.Location) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((LocationRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$idName = ((LocationRealmProxyInterface) object).realmGet$idName();
            if (realmGet$idName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idNameIndex, rowIndex, realmGet$idName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idNameIndex, rowIndex, false);
            }
            String realmGet$province = ((LocationRealmProxyInterface) object).realmGet$province();
            if (realmGet$province != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.provinceIndex, rowIndex, realmGet$province, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.provinceIndex, rowIndex, false);
            }
            String realmGet$city = ((LocationRealmProxyInterface) object).realmGet$city();
            if (realmGet$city != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cityIndex, rowIndex, realmGet$city, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cityIndex, rowIndex, false);
            }
            String realmGet$area = ((LocationRealmProxyInterface) object).realmGet$area();
            if (realmGet$area != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.areaIndex, rowIndex, realmGet$area, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.areaIndex, rowIndex, false);
            }
            String realmGet$endPage = ((LocationRealmProxyInterface) object).realmGet$endPage();
            if (realmGet$endPage != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.endPageIndex, rowIndex, realmGet$endPage, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.endPageIndex, rowIndex, false);
            }
        }
    }

    public static com.Realm.entry.Location createDetachedCopy(com.Realm.entry.Location realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.Realm.entry.Location unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.Realm.entry.Location();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.Realm.entry.Location) cachedObject.object;
            }
            unmanagedObject = (com.Realm.entry.Location) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        LocationRealmProxyInterface unmanagedCopy = (LocationRealmProxyInterface) unmanagedObject;
        LocationRealmProxyInterface realmSource = (LocationRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$idName(realmSource.realmGet$idName());
        unmanagedCopy.realmSet$province(realmSource.realmGet$province());
        unmanagedCopy.realmSet$city(realmSource.realmGet$city());
        unmanagedCopy.realmSet$area(realmSource.realmGet$area());
        unmanagedCopy.realmSet$endPage(realmSource.realmGet$endPage());

        return unmanagedObject;
    }

    static com.Realm.entry.Location update(Realm realm, com.Realm.entry.Location realmObject, com.Realm.entry.Location newObject, Map<RealmModel, RealmObjectProxy> cache) {
        LocationRealmProxyInterface realmObjectTarget = (LocationRealmProxyInterface) realmObject;
        LocationRealmProxyInterface realmObjectSource = (LocationRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$idName(realmObjectSource.realmGet$idName());
        realmObjectTarget.realmSet$province(realmObjectSource.realmGet$province());
        realmObjectTarget.realmSet$city(realmObjectSource.realmGet$city());
        realmObjectTarget.realmSet$area(realmObjectSource.realmGet$area());
        realmObjectTarget.realmSet$endPage(realmObjectSource.realmGet$endPage());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Location = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{idName:");
        stringBuilder.append(realmGet$idName() != null ? realmGet$idName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{province:");
        stringBuilder.append(realmGet$province() != null ? realmGet$province() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{city:");
        stringBuilder.append(realmGet$city() != null ? realmGet$city() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{area:");
        stringBuilder.append(realmGet$area() != null ? realmGet$area() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{endPage:");
        stringBuilder.append(realmGet$endPage() != null ? realmGet$endPage() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationRealmProxy aLocation = (LocationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLocation.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLocation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLocation.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
