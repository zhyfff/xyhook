package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(com.Realm.entry.GoodsClassBean.class);
        modelClasses.add(com.Realm.entry.HostBean.class);
        modelClasses.add(com.Realm.entry.Location.class);
        modelClasses.add(com.Realm.entry.TaskBean.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(com.Realm.entry.GoodsClassBean.class, io.realm.GoodsClassBeanRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.Realm.entry.HostBean.class, io.realm.HostBeanRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.Realm.entry.Location.class, io.realm.LocationRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.Realm.entry.TaskBean.class, io.realm.TaskBeanRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return io.realm.GoodsClassBeanRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return io.realm.HostBeanRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return io.realm.LocationRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return io.realm.TaskBeanRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return io.realm.GoodsClassBeanRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return io.realm.HostBeanRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return io.realm.LocationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return io.realm.TaskBeanRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return io.realm.GoodsClassBeanRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return io.realm.HostBeanRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return io.realm.LocationRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return io.realm.TaskBeanRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
                return clazz.cast(new io.realm.GoodsClassBeanRealmProxy());
            }
            if (clazz.equals(com.Realm.entry.HostBean.class)) {
                return clazz.cast(new io.realm.HostBeanRealmProxy());
            }
            if (clazz.equals(com.Realm.entry.Location.class)) {
                return clazz.cast(new io.realm.LocationRealmProxy());
            }
            if (clazz.equals(com.Realm.entry.TaskBean.class)) {
                return clazz.cast(new io.realm.TaskBeanRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return clazz.cast(io.realm.GoodsClassBeanRealmProxy.copyOrUpdate(realm, (com.Realm.entry.GoodsClassBean) obj, update, cache));
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return clazz.cast(io.realm.HostBeanRealmProxy.copyOrUpdate(realm, (com.Realm.entry.HostBean) obj, update, cache));
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.copyOrUpdate(realm, (com.Realm.entry.Location) obj, update, cache));
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return clazz.cast(io.realm.TaskBeanRealmProxy.copyOrUpdate(realm, (com.Realm.entry.TaskBean) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            io.realm.GoodsClassBeanRealmProxy.insert(realm, (com.Realm.entry.GoodsClassBean) object, cache);
        } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
            io.realm.HostBeanRealmProxy.insert(realm, (com.Realm.entry.HostBean) object, cache);
        } else if (clazz.equals(com.Realm.entry.Location.class)) {
            io.realm.LocationRealmProxy.insert(realm, (com.Realm.entry.Location) object, cache);
        } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            io.realm.TaskBeanRealmProxy.insert(realm, (com.Realm.entry.TaskBean) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
                io.realm.GoodsClassBeanRealmProxy.insert(realm, (com.Realm.entry.GoodsClassBean) object, cache);
            } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
                io.realm.HostBeanRealmProxy.insert(realm, (com.Realm.entry.HostBean) object, cache);
            } else if (clazz.equals(com.Realm.entry.Location.class)) {
                io.realm.LocationRealmProxy.insert(realm, (com.Realm.entry.Location) object, cache);
            } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
                io.realm.TaskBeanRealmProxy.insert(realm, (com.Realm.entry.TaskBean) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
                    io.realm.GoodsClassBeanRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
                    io.realm.HostBeanRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.Location.class)) {
                    io.realm.LocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
                    io.realm.TaskBeanRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            io.realm.GoodsClassBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.GoodsClassBean) obj, cache);
        } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
            io.realm.HostBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.HostBean) obj, cache);
        } else if (clazz.equals(com.Realm.entry.Location.class)) {
            io.realm.LocationRealmProxy.insertOrUpdate(realm, (com.Realm.entry.Location) obj, cache);
        } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            io.realm.TaskBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.TaskBean) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
                io.realm.GoodsClassBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.GoodsClassBean) object, cache);
            } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
                io.realm.HostBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.HostBean) object, cache);
            } else if (clazz.equals(com.Realm.entry.Location.class)) {
                io.realm.LocationRealmProxy.insertOrUpdate(realm, (com.Realm.entry.Location) object, cache);
            } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
                io.realm.TaskBeanRealmProxy.insertOrUpdate(realm, (com.Realm.entry.TaskBean) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
                    io.realm.GoodsClassBeanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.HostBean.class)) {
                    io.realm.HostBeanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.Location.class)) {
                    io.realm.LocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.Realm.entry.TaskBean.class)) {
                    io.realm.TaskBeanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return clazz.cast(io.realm.GoodsClassBeanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return clazz.cast(io.realm.HostBeanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return clazz.cast(io.realm.TaskBeanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return clazz.cast(io.realm.GoodsClassBeanRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return clazz.cast(io.realm.HostBeanRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return clazz.cast(io.realm.TaskBeanRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.Realm.entry.GoodsClassBean.class)) {
            return clazz.cast(io.realm.GoodsClassBeanRealmProxy.createDetachedCopy((com.Realm.entry.GoodsClassBean) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.Realm.entry.HostBean.class)) {
            return clazz.cast(io.realm.HostBeanRealmProxy.createDetachedCopy((com.Realm.entry.HostBean) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.Realm.entry.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createDetachedCopy((com.Realm.entry.Location) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.Realm.entry.TaskBean.class)) {
            return clazz.cast(io.realm.TaskBeanRealmProxy.createDetachedCopy((com.Realm.entry.TaskBean) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
