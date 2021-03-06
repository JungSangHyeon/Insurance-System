package control.salesSystem.salesManAspect.WatchSalesTrainingPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan.WatchDetailSalesTrainingPlanView;
import view.panel.BasicPanel;

public class WatchDetailSalesTrainingPlanSystem extends SalesSystem {
	
	// Association
	private int salesTrainingPlanID;
	
	// Constructor
	public WatchDetailSalesTrainingPlanSystem(int ID) {this.salesTrainingPlanID = ID;}
	
	@Override
	public BasicPanel getView() {return new WatchDetailSalesTrainingPlanView(this.actionListener, this.salesTrainingPlanID,this.salesTrainigPlanList);}
	
	// no use 
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WatchDetailSalesTrainingPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
