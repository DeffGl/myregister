package com.example.regservicebuilder.service.persistence;

import com.example.regservicebuilder.NoSuchFarmerException;
import com.example.regservicebuilder.model.Farmer;
import com.example.regservicebuilder.model.impl.FarmerImpl;
import com.example.regservicebuilder.model.impl.FarmerModelImpl;
import com.example.regservicebuilder.service.persistence.DistrictPersistence;
import com.example.regservicebuilder.service.persistence.FarmerPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the farmer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerPersistence
 * @see FarmerUtil
 * @generated
 */
public class FarmerPersistenceImpl extends BasePersistenceImpl<Farmer>
    implements FarmerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FarmerUtil} to access the farmer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FarmerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, FarmerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_FARMER = "SELECT farmer FROM Farmer farmer";
    private static final String _SQL_COUNT_FARMER = "SELECT COUNT(farmer) FROM Farmer farmer";
    private static final String _ORDER_BY_ENTITY_ALIAS = "farmer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Farmer exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FarmerPersistenceImpl.class);
    private static Farmer _nullFarmer = new FarmerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Farmer> toCacheModel() {
                return _nullFarmerCacheModel;
            }
        };

    private static CacheModel<Farmer> _nullFarmerCacheModel = new CacheModel<Farmer>() {
            @Override
            public Farmer toEntityModel() {
                return _nullFarmer;
            }
        };

    @BeanReference(type = DistrictPersistence.class)
    protected DistrictPersistence districtPersistence;
    protected TableMapper<Farmer, com.example.regservicebuilder.model.District> farmerToDistrictTableMapper;

    public FarmerPersistenceImpl() {
        setModelClass(Farmer.class);
    }

    /**
     * Caches the farmer in the entity cache if it is enabled.
     *
     * @param farmer the farmer
     */
    @Override
    public void cacheResult(Farmer farmer) {
        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        farmer.resetOriginalValues();
    }

    /**
     * Caches the farmers in the entity cache if it is enabled.
     *
     * @param farmers the farmers
     */
    @Override
    public void cacheResult(List<Farmer> farmers) {
        for (Farmer farmer : farmers) {
            if (EntityCacheUtil.getResult(
                        FarmerModelImpl.ENTITY_CACHE_ENABLED, FarmerImpl.class,
                        farmer.getPrimaryKey()) == null) {
                cacheResult(farmer);
            } else {
                farmer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all farmers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FarmerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FarmerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the farmer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Farmer farmer) {
        EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Farmer> farmers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Farmer farmer : farmers) {
            EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, farmer.getPrimaryKey());
        }
    }

    /**
     * Creates a new farmer with the primary key. Does not add the farmer to the database.
     *
     * @param farmerId the primary key for the new farmer
     * @return the new farmer
     */
    @Override
    public Farmer create(long farmerId) {
        Farmer farmer = new FarmerImpl();

        farmer.setNew(true);
        farmer.setPrimaryKey(farmerId);

        return farmer;
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.example.regservicebuilder.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return remove((Serializable) farmerId);
    }

    /**
     * Removes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer that was removed
     * @throws com.example.regservicebuilder.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer remove(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Farmer farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

            if (farmer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(farmer);
        } catch (NoSuchFarmerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Farmer removeImpl(Farmer farmer) throws SystemException {
        farmer = toUnwrappedModel(farmer);

        farmerToDistrictTableMapper.deleteLeftPrimaryKeyTableMappings(farmer.getPrimaryKey());

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(farmer)) {
                farmer = (Farmer) session.get(FarmerImpl.class,
                        farmer.getPrimaryKeyObj());
            }

            if (farmer != null) {
                session.delete(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (farmer != null) {
            clearCache(farmer);
        }

        return farmer;
    }

    @Override
    public Farmer updateImpl(com.example.regservicebuilder.model.Farmer farmer)
        throws SystemException {
        farmer = toUnwrappedModel(farmer);

        boolean isNew = farmer.isNew();

        Session session = null;

        try {
            session = openSession();

            if (farmer.isNew()) {
                session.save(farmer);

                farmer.setNew(false);
            } else {
                session.merge(farmer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
            FarmerImpl.class, farmer.getPrimaryKey(), farmer);

        return farmer;
    }

    protected Farmer toUnwrappedModel(Farmer farmer) {
        if (farmer instanceof FarmerImpl) {
            return farmer;
        }

        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setNew(farmer.isNew());
        farmerImpl.setPrimaryKey(farmer.getPrimaryKey());

        farmerImpl.setFarmerId(farmer.getFarmerId());
        farmerImpl.setOrganizationName(farmer.getOrganizationName());
        farmerImpl.setLegalForm(farmer.getLegalForm());
        farmerImpl.setInn(farmer.getInn());
        farmerImpl.setKpp(farmer.getKpp());
        farmerImpl.setOgrn(farmer.getOgrn());
        farmerImpl.setDistrictId(farmer.getDistrictId());
        farmerImpl.setRegistrationDate(farmer.getRegistrationDate());
        farmerImpl.setArchived(farmer.getArchived());

        return farmerImpl;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer
     * @throws com.example.regservicebuilder.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFarmerException, SystemException {
        Farmer farmer = fetchByPrimaryKey(primaryKey);

        if (farmer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFarmerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or throws a {@link com.example.regservicebuilder.NoSuchFarmerException} if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer
     * @throws com.example.regservicebuilder.NoSuchFarmerException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer findByPrimaryKey(long farmerId)
        throws NoSuchFarmerException, SystemException {
        return findByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Farmer farmer = (Farmer) EntityCacheUtil.getResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                FarmerImpl.class, primaryKey);

        if (farmer == _nullFarmer) {
            return null;
        }

        if (farmer == null) {
            Session session = null;

            try {
                session = openSession();

                farmer = (Farmer) session.get(FarmerImpl.class, primaryKey);

                if (farmer != null) {
                    cacheResult(farmer);
                } else {
                    EntityCacheUtil.putResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                        FarmerImpl.class, primaryKey, _nullFarmer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FarmerModelImpl.ENTITY_CACHE_ENABLED,
                    FarmerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return farmer;
    }

    /**
     * Returns the farmer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param farmerId the primary key of the farmer
     * @return the farmer, or <code>null</code> if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer fetchByPrimaryKey(long farmerId) throws SystemException {
        return fetchByPrimaryKey((Serializable) farmerId);
    }

    /**
     * Returns all the farmers.
     *
     * @return the farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the farmers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.regservicebuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @return the range of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the farmers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.regservicebuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Farmer> list = (List<Farmer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FARMER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FARMER;

                if (pagination) {
                    sql = sql.concat(FarmerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Farmer>(list);
                } else {
                    list = (List<Farmer>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the farmers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Farmer farmer : findAll()) {
            remove(farmer);
        }
    }

    /**
     * Returns the number of farmers.
     *
     * @return the number of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FARMER);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the districts associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.regservicebuilder.model.District> getDistricts(
        long pk) throws SystemException {
        return getDistricts(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    /**
     * Returns a range of all the districts associated with the farmer.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.regservicebuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the farmer
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @return the range of districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.regservicebuilder.model.District> getDistricts(
        long pk, int start, int end) throws SystemException {
        return getDistricts(pk, start, end, null);
    }

    /**
     * Returns an ordered range of all the districts associated with the farmer.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.example.regservicebuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param pk the primary key of the farmer
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<com.example.regservicebuilder.model.District> getDistricts(
        long pk, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return farmerToDistrictTableMapper.getRightBaseModels(pk, start, end,
            orderByComparator);
    }

    /**
     * Returns the number of districts associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @return the number of districts associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getDistrictsSize(long pk) throws SystemException {
        long[] pks = farmerToDistrictTableMapper.getRightPrimaryKeys(pk);

        return pks.length;
    }

    /**
     * Returns <code>true</code> if the district is associated with the farmer.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @return <code>true</code> if the district is associated with the farmer; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDistrict(long pk, long districtPK)
        throws SystemException {
        return farmerToDistrictTableMapper.containsTableMapping(pk, districtPK);
    }

    /**
     * Returns <code>true</code> if the farmer has any districts associated with it.
     *
     * @param pk the primary key of the farmer to check for associations with districts
     * @return <code>true</code> if the farmer has any districts associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    @Override
    public boolean containsDistricts(long pk) throws SystemException {
        if (getDistrictsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistrict(long pk, long districtPK) throws SystemException {
        farmerToDistrictTableMapper.addTableMapping(pk, districtPK);
    }

    /**
     * Adds an association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param district the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistrict(long pk,
        com.example.regservicebuilder.model.District district)
        throws SystemException {
        farmerToDistrictTableMapper.addTableMapping(pk, district.getPrimaryKey());
    }

    /**
     * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistricts(long pk, long[] districtPKs)
        throws SystemException {
        for (long districtPK : districtPKs) {
            farmerToDistrictTableMapper.addTableMapping(pk, districtPK);
        }
    }

    /**
     * Adds an association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void addDistricts(long pk,
        List<com.example.regservicebuilder.model.District> districts)
        throws SystemException {
        for (com.example.regservicebuilder.model.District district : districts) {
            farmerToDistrictTableMapper.addTableMapping(pk,
                district.getPrimaryKey());
        }
    }

    /**
     * Clears all associations between the farmer and its districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer to clear the associated districts from
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void clearDistricts(long pk) throws SystemException {
        farmerToDistrictTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
    }

    /**
     * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPK the primary key of the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistrict(long pk, long districtPK)
        throws SystemException {
        farmerToDistrictTableMapper.deleteTableMapping(pk, districtPK);
    }

    /**
     * Removes the association between the farmer and the district. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param district the district
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistrict(long pk,
        com.example.regservicebuilder.model.District district)
        throws SystemException {
        farmerToDistrictTableMapper.deleteTableMapping(pk,
            district.getPrimaryKey());
    }

    /**
     * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistricts(long pk, long[] districtPKs)
        throws SystemException {
        for (long districtPK : districtPKs) {
            farmerToDistrictTableMapper.deleteTableMapping(pk, districtPK);
        }
    }

    /**
     * Removes the association between the farmer and the districts. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeDistricts(long pk,
        List<com.example.regservicebuilder.model.District> districts)
        throws SystemException {
        for (com.example.regservicebuilder.model.District district : districts) {
            farmerToDistrictTableMapper.deleteTableMapping(pk,
                district.getPrimaryKey());
        }
    }

    /**
     * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districtPKs the primary keys of the districts to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDistricts(long pk, long[] districtPKs)
        throws SystemException {
        Set<Long> newDistrictPKsSet = SetUtil.fromArray(districtPKs);
        Set<Long> oldDistrictPKsSet = SetUtil.fromArray(farmerToDistrictTableMapper.getRightPrimaryKeys(
                    pk));

        Set<Long> removeDistrictPKsSet = new HashSet<Long>(oldDistrictPKsSet);

        removeDistrictPKsSet.removeAll(newDistrictPKsSet);

        for (long removeDistrictPK : removeDistrictPKsSet) {
            farmerToDistrictTableMapper.deleteTableMapping(pk, removeDistrictPK);
        }

        newDistrictPKsSet.removeAll(oldDistrictPKsSet);

        for (long newDistrictPK : newDistrictPKsSet) {
            farmerToDistrictTableMapper.addTableMapping(pk, newDistrictPK);
        }
    }

    /**
     * Sets the districts associated with the farmer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the farmer
     * @param districts the districts to be associated with the farmer
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void setDistricts(long pk,
        List<com.example.regservicebuilder.model.District> districts)
        throws SystemException {
        try {
            long[] districtPKs = new long[districts.size()];

            for (int i = 0; i < districts.size(); i++) {
                com.example.regservicebuilder.model.District district = districts.get(i);

                districtPKs[i] = district.getPrimaryKey();
            }

            setDistricts(pk, districtPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(FarmerModelImpl.MAPPING_TABLE_REGS_REGS_FARMER_DISTRICTS_NAME);
        }
    }

    /**
     * Initializes the farmer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.example.regservicebuilder.model.Farmer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Farmer>> listenersList = new ArrayList<ModelListener<Farmer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Farmer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        farmerToDistrictTableMapper = TableMapperFactory.getTableMapper("Regs_Regs_Farmer_Districts",
                "farmerId", "districtId", this, districtPersistence);
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FarmerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        TableMapperFactory.removeTableMapper("Regs_Regs_Farmer_Districts");
    }
}
