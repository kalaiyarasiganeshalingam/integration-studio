package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ProxyServiceFaultContainerCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.commands.ProxyServiceSequenceAndEndpointContainerCreateCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceFaultContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.ProxyServiceSequenceAndEndpointContainerEditPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.providers.EsbElementTypes;

/**
 * @generated
 */
public class ProxyServiceContainer2ItemSemanticEditPolicy extends EsbBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public ProxyServiceContainer2ItemSemanticEditPolicy() {
        super(EsbElementTypes.ProxyServiceContainer_3673);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (EsbElementTypes.ProxyServiceSequenceAndEndpointContainer_3487 == req.getElementType()) {
            return getGEFWrapper(new ProxyServiceSequenceAndEndpointContainerCreateCommand(req));
        }
        if (EsbElementTypes.ProxyServiceFaultContainer_3488 == req.getElementType()) {
            return getGEFWrapper(new ProxyServiceFaultContainerCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyChildNodesCommand(cmd);
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    /**
     * @generated
     */
    private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
        View view = (View) getHost().getModel();
        for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
            Node node = (Node) nit.next();
            switch (EsbVisualIDRegistry.getVisualID(node)) {
            case ProxyServiceSequenceAndEndpointContainerEditPart.VISUAL_ID:
                cmd.add(new DestroyElementCommand(
                        new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
                // don't need explicit deletion of node as parent's view deletion would clean child views as well 
                // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
                break;
            case ProxyServiceFaultContainerEditPart.VISUAL_ID:
                cmd.add(new DestroyElementCommand(
                        new DestroyElementRequest(getEditingDomain(), node.getElement(), false))); // directlyOwned: true
                // don't need explicit deletion of node as parent's view deletion would clean child views as well 
                // cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), node));
                break;
            }
        }
    }

}
